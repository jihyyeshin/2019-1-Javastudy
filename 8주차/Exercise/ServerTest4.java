import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerTest4 {

	   public static void main(String[] args) {
	      
	      SocketChannel socketChannel = null;
	      try {
	         //클라이언트가  로컬ip,5001포트 서버 연결요청 (Blocking방식)
	         

	         System.out.println("[연결 요청]");
	         
	         System.out.println("[연결 성공]");
	         
	         
	         
	         
	         ByteBuffer byteBuffer = null;
	         Charset charset = Charset.forName("UTF-8");
	         //클라이언트가 서버로 먼저 "Hello Server"를 보낸다.

	         
	         System.out.println("[데이터 보내기 성공]");
	         
	         
	         
	         //서버가 보낸 "Hello Client"를 클라이언트가 받음

	         
	         
	         
	         System.out.println("[데이터 받기 성공]:" + message);
	         
	      } catch(Exception e) {}
	      
	      if(socketChannel.isOpen()) {
	         try {
	            socketChannel.close();
	         } catch (IOException e1) {}
	      }
	   }

