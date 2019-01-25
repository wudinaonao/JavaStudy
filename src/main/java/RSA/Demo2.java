package RSA;
// import sun.misc.BASE64Decoder;
// import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import Tools.Tool;

/**
 * @program: study
 * @description: RSA算法实现(官方)
 * @author: Wen lyuzhao
 * @create: 2019-01-22 20:32
 **/
public class Demo2 {
    public static final String RSA_ALGORITHM = "RSA";
    public static final Charset UTF8 = Charset.forName("UTF-8");

    public static void main(String [] args) throws Exception {
        // generate public and private keys
        // KeyPair keyPair = buildKeyPair();
        // PublicKey publicKey = keyPair.getPublic();
        // savePublicKey(publicKey);
        // PrivateKey privateKey = keyPair.getPrivate();
        // savePrivateKey(privateKey);

        // load publicKey and privateKey
        PublicKey publicKey = loadPublicKey(Tool.readFileText("publicKey.keystore"));
        PrivateKey privateKey = loadPrivateKey(Tool.readFileText("privateKey.keystore"));

        // encrypt the message
        byte[] encrypted = encrypt(privateKey, "wudinaonao-->qq498191481");
        System.out.println(base64Encode(encrypted));  // <<encrypted message>>

        // test encrypt string
        // String testEncrpyStr = "BTwtyzA6+2Mdx5PJdUJle/Du3dhOVd6PRnj0a4/6s2Nq16HQKpTBrn0ckz5IiIJ1EPDIqxuMDsCOihIuAi+RVBw/wB+26v5O/wZkDvoFK7TDssnbeRsbpk6NhmSIUOuRKKlr2aQn6bJlesAnhNqw+1Rx/ItovJv1bxaU3FBAhyYhGePZrw91OwNdFvdyUc3goHI2tOMPg3k/qClfIWWHcUMaCXil85Q2tasTs3xPV2Do+qzEfLls+MM177Hat8ewnqtfgF8RRfc/Y7v+AkWe0VX7EfWQNsho1hN//+HYLlbf74MbSh8hG8HpFh+cKwmsnYBbTkzDemeFtUSaACfLvA==";
        String testEncrpyStr = "DTgFEqHSenf6++powNIwag94GWs0L2RRXOPGnHnJW/2kC/uH1Fhdr4RtLZmJwPFyqQowrIFiLAvOF0WkNucCoZ8joZYC2D6ayY2sa2iwBf9KJoegK/Vgx4QT+sv0GItNbjayq89AY75oVu/iUSyLPDIwUtVYULCT98XyJuZCRccwFScdiI18bHkaQORl5F/ZdZVe8zYNWlhkwDSFy8G5eWN8KXwmWyTwGGua86uA4dzeviN4ct/1ofY0a9jWuS1+XbfdMkhWOKMp7c4oGPxIsvqrNqv48hbeQqK4ZtgSsZP3y5+h/HEscbgDCOM7Ytxon9CD12tPlP0Hgsbvwmu7Vw==";
        byte[] testEncrpyByte = testEncrpyStr.getBytes("UTF-8");

        // decrypt the message
        byte[] secret = decrypt(publicKey, testEncrpyByte);
        System.out.println(new String(secret, UTF8));     // This is a secret message
    }

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.genKeyPair();
    }

    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(message.getBytes(UTF8));
    }

    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(encrypted);
    }

    /**
     * 从字符串中加载公钥
     *
     */
    public static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception {
        try {
            byte[] buffer = base64Decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
        try {
            byte[] buffer = base64Decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static void savePublicKey(PublicKey publicKey) throws IOException {
        // 得到公钥字符串
        String publicKeyString = base64Encode(publicKey.getEncoded());
        System.out.println("publicKeyString="+publicKeyString);
        FileWriter fw = new FileWriter("publicKey.keystore");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(publicKeyString);
        bw.close();
    }

    public static void savePrivateKey(PrivateKey privateKey) throws IOException {
        // 得到私钥字符串
        String privateKeyString = base64Encode(privateKey.getEncoded());
        System.out.println("privateKeyString="+privateKeyString);

        BufferedWriter bw = new BufferedWriter(new FileWriter("privateKey.keystore"));
        bw.write(privateKeyString);
        bw.close();
    }

    public static String base64Encode(byte[] data) {
        return Base64.encodeBase64String(data);
        // return new BASE64Encoder().encode(data);
    }
    public static byte[] base64Decode(String data){
        return Base64.decodeBase64(data);
        // return new BASE64Decoder().decodeBuffer(data);
    }
}
