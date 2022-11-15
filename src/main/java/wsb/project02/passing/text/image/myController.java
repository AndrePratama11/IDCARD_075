/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsb.project02.passing.text.image;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
public class myController {
    @RequestMapping("/sendData")
    @ResponseBody
    public String getData(@RequestParam("mytext") String getText,
                          @RequestParam("myImage") MultipartFile image,
                          @RequestParam("tanggal")
                          @DateTimeFormat(pattern="yyyy-MM-dd") Date date) 
            throws IOException
            {
                SimpleDateFormat tanggal = new SimpleDateFormat("dd-MM-yyyy");
                String newTanggal = tanggal.format(date);
                String blob = Base64.encodeBase64String(image.getBytes());
        return "<fieldset>"+"<h2> Data Diri"+"<h3> Nama : "+getText+"<br>"+"Tanggal Lahir : "+   newTanggal+"<br>"+
                "<img width='300' src='data:image/png;base64,"+blob+"'/>"+"</fieldset>";
    }
}
