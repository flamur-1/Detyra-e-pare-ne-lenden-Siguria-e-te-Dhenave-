package fisnik;

import java.util.Scanner;

import java.io.Console;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Test {

	 static final String NL = System.getProperty("line.separator");
	 
	 static KeyPair getKeyPair() throws Exception{
		 
		 KeyPair keyPair = createKeyPair(1024);
		 
		 return keyPair;
	 }
	 static PrivateKey getPrivateKey() throws Exception {
		 
		 PrivateKey privateKey = getKeyPair().getPrivate();
		 
		 return privateKey;
		 
	 }
	 static PublicKey getPublicKey() throws Exception{
		 
		 PublicKey publicKey = getKeyPair().getPublic();
		 
		 return publicKey;
		 
	 }
	 
    public static void main(String[] args) throws Exception {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Sheno 1 per krijim dhe 2 per paraqitje ne ekran: ");
    	int paraqit = input.nextInt();
    	String nothing = input.nextLine();
    	
    	if(paraqit ==1) {
    	
    	System.out.println("Create keys: ");
    	String user = input.nextLine();
    	
    	 
    	
          String ENCODED_PRIVATE_FILENAME =  user  + "EncodedPrivateKey.txt";
          String ENCODED_PUBLIC_FILENAME =  user + "EncodedPublicKey.txt";
          String XML_PRIVATE_FILENAME =  "RSA/" + user + "XmlPrivateKey.xml";
          String XML_PUBLIC_FILENAME = "RSA/" + user + "PublicKey.pub.xml";
      
          File file = new File(XML_PRIVATE_FILENAME);
          File file1 = new File(XML_PUBLIC_FILENAME);
          boolean exists = file.exists();
          boolean exists1 = file1.exists();
        	
        if(exists && exists1) {
        
        System.out.println("Keta celesa ekzistojne tashme!");
        	
        }
        else {
        String privateKeyAsEncoded = getPrivateKeyAsEncoded(getPrivateKey());
    //  print("Private key in Encoded format:" + NL + privateKeyAsEncoded);
       writeFile(privateKeyAsEncoded, ENCODED_PRIVATE_FILENAME);
     //   print("About to write PUBLIC key in Encoded (Java) format.");
        String publicKeyAdEncoded = getPublicKeyAsEncoded(getPublicKey());
        writeFile(publicKeyAdEncoded, ENCODED_PUBLIC_FILENAME);
        
        System.out.println("Eshte krijuar celesi privat " + user + ".xml");
        System.out.println("Eshte krijuar celesi publik " + user + ".pub.xml");
      //  print("About to write PRIVATE key in XML (.Net) format.");
        String privateKeyAsXml = getPrivateKeyAsXml(getPrivateKey());
        writeFile(privateKeyAsXml, user + "privateKey");
        
        String publicKeyAsXml = getPublicKeyAsXml(getPublicKey());
    	
    	
           // print("About to write PRIVATE key in XML (.Net) format.");
            
            writeFile(privateKeyAsXml, user + "privateKey");
     //   print("Private key in XML format:" + NL + privateKeyAsXml);
        
        writeFile(privateKeyAsXml, XML_PRIVATE_FILENAME);
        
        //print("Public key in XML format: " + NL + publicKeyAsXml);
        writeFile(publicKeyAsXml, XML_PUBLIC_FILENAME);
       
        }
    	}
    	else if(paraqit ==2) {
    		
    		
    		System.out.println("Sheno cilin qeles deshiron ta paraqesesh: ");
        	String user = input.nextLine();
        	
        	 
        	
              String ENCODED_PRIVATE_FILENAME =  user  + "EncodedPrivateKey.txt";
              String ENCODED_PUBLIC_FILENAME =  user + "EncodedPublicKey.txt";
              String XML_PRIVATE_FILENAME =  "RSA/" + user + "XmlPrivateKey.xml";
              String XML_PUBLIC_FILENAME = "RSA/" + user + "PublicKey.pub.xml";
         
              File file = new File(XML_PRIVATE_FILENAME);
              File file1 = new File(XML_PUBLIC_FILENAME);
              boolean exists = file.exists();
              boolean exists1 = file1.exists();
            	
            if(exists && exists1) {
            
            	 print("About to write PRIVATE key in XML (.Net) format.");
                 String privateKeyAsXml = getPrivateKeyAsXml(getPrivateKey());
               //  writeFile(privateKeyAsXml, user + "privateKey");
                 
                 String publicKeyAsXml = getPublicKeyAsXml(getPublicKey());
             	
             	System.out.println("Sheno 1 per private xml file dhe 2 per public xml file: ");
             	int xml = input.nextInt();
             	String nothing1 = input.nextLine();
             	if(xml ==1) {
                    // print("About to write PRIVATE key in XML (.Net) format.");
                     
                 //    writeFile(privateKeyAsXml, user + "privateKey");
                 print("Private key in XML format:" + NL + privateKeyAsXml);
                 
                 writeFile(privateKeyAsXml, XML_PRIVATE_FILENAME);
             	}
             	else {
                 print("Public key in XML format: " + NL + publicKeyAsXml);
                 writeFile(publicKeyAsXml, XML_PUBLIC_FILENAME);
             	}
                 
         	
            }
            else {
            	
            	System.out.println("Nuk ekziston nje celes i tille!");
            }
    	}
    	else if(paraqit ==3) {
    		
    		 DeleteUser();
    		
    	}
    }
    static KeyPair createKeyPair(int keyLength) throws NoSuchAlgorithmException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
        keygen.initialize(keyLength, new SecureRandom());
        KeyPair keyPair = keygen.generateKeyPair();
        return keyPair;
    }
 static KeyPair createKeyPair1(int keyLength) throws NoSuchAlgorithmException {
        KeyPairGenerator keygen1 = KeyPairGenerator.getInstance("RSA");
        keygen1.initialize(keyLength, new SecureRandom());
        KeyPair keyPair1 = keygen1.generateKeyPair();
        return keyPair1;
    }
    static String getPrivateKeyAsEncoded(PrivateKey privateKey){
        byte[] privateKeyEncodedBytes = privateKey.getEncoded();
        return getBase64(privateKeyEncodedBytes);
    }
    static String getPublicKeyAsEncoded(PublicKey publicKey){
        byte[] publicKeyEncoded = publicKey.getEncoded();
        return getBase64(publicKeyEncoded);
    }
    static String getPrivateKeyAsXml(PrivateKey privateKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec spec = keyFactory.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);
        StringBuilder sb = new StringBuilder();
        sb.append("<RSAKeyValue>" + NL);
        sb.append(getElement("Modulus", spec.getModulus()));
        sb.append(getElement("Exponent", spec.getPublicExponent()));
        sb.append(getElement("P", spec.getPrimeP()));
        sb.append(getElement("Q", spec.getPrimeQ()));
        sb.append(getElement("DP", spec.getPrimeExponentP()));
        sb.append(getElement("DQ", spec.getPrimeExponentQ()));
        sb.append(getElement("InverseQ", spec.getCrtCoefficient()));
        sb.append(getElement("D", spec.getPrivateExponent()));
        sb.append("</RSAKeyValue>");
        return sb.toString();
    }
    static String getPublicKeyAsXml(PublicKey publicKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec spec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        StringBuilder sb = new StringBuilder();
        sb.append("<RSAKeyValue>" + NL);
        sb.append(getElement("Modulus", spec.getModulus()));
        sb.append(getElement("Exponent", spec.getPublicExponent()));
        sb.append("</RSAKeyValue>");
        return sb.toString();
    }
    static String getElement(String name, BigInteger bigInt) throws Exception {
        byte[] bytesFromBigInt = getBytesFromBigInt(bigInt);
        String elementContent = getBase64(bytesFromBigInt);
        return String.format("  <%s>%s</%s>%s", name, elementContent, name, NL);
    }
    static byte[] getBytesFromBigInt(BigInteger bigInt){
        byte[] bytes = bigInt.toByteArray();
        int length = bytes.length;
        
        if(length % 2 != 0 && bytes[0] == 0) {
            bytes = Arrays.copyOfRange(bytes, 1, length);
        }
        return bytes;
    }
    static String getBase64(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }
    static void writeFile(String text, String filename) throws Exception{
        try(PrintWriter writer = new PrintWriter(filename)){
            writer.write(text);
        }
    }
    static void print(String line){
        System.out.println(line);
    }
   
    static void DeleteUser() {
    	
    	Scanner input = new Scanner(System.in);
    	System.out.println("Sheno userin qe deshiron ta fshish: ");
    	String user = input.nextLine();
    	
    	
    	
    	String XML_PRIVATE_FILENAME =  "RSA/" + user + "XmlPrivateKey.xml";
        String XML_PUBLIC_FILENAME = "RSA/" + user + "PublicKey.pub.xml";
    //  KeyPair keyPair = createKeyPair(1024);
     // KeyPair keyPair1 = createKeyPair1(1024);
     // print("Created KeyPair.");
     // PrivateKey privateKey = keyPair.getPrivate();
     // PublicKey publicKey = keyPair.getPublic();
        File file2 = new File(XML_PRIVATE_FILENAME);
        File file1 = new File(XML_PUBLIC_FILENAME);
        boolean exists = file2.exists();
        boolean exists1 = file1.exists();
        
        if(file2.delete() && file1.delete()) {
        	
        	
        	System.out.println("Fajllat jane fshire!");
        	
        }
        else {
        	
        	System.out.println("Keta fajlla nuk ekzistojne!");
        	
        }
        
        
    }
}
