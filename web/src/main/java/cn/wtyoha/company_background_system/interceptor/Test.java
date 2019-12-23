package cn.wtyoha.company_background_system.interceptor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Test.class.getClassLoader().getResourceAsStream("updatePermissionUrl.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
        while (br.ready()) {
            System.out.println(br.readLine());
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("996895"));
    }
}
