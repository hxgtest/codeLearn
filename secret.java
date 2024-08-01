import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;
import java.util.Base64;

public class secret {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 请在指定位置填写代码
        /********* Begin *********/
        try {
            // 创建一个DESKeySpec对象
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56); // DES算法密钥长度必须是56位
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            // 创建一个DES Cipher对象
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // 初始化Cipher对象
            SecretKeySpec keySpec = new SecretKeySpec(bytesKey, "DES");

            // 加密过程
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encrypted = cipher.doFinal(str.getBytes());
            String encryptedStr = Base64.getEncoder().encodeToString(encrypted);
            System.out.println("加密后：" + encryptedStr);

            // 解密过程
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedStr));
            String originalStr = new String(original);
            System.out.println("解密后：" + originalStr);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        /********* End *********/
    }
}
