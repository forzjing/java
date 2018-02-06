package javaSe_Example;

import java.io.*;

public class File_listFiles_BatchRename_HtmltoJsp {  //类名可以叫Main

    public static void main(String[] args) throws IOException {
         rename();
         replace();
        //可以勒
    }

    private static void replace() throws IOException {
        //2遍歷文件内容，重置字符串；
        File file=new File("D:\\webProject\\taotaobootstrap\\batchRenameHtmltoJsp\\src\\pages");
        File[] files=file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".jsp");
            }
        });
        BufferedReader br=null;
        BufferedWriter bw=null;
        int index=0;
        for (File jsp :
                files) {
            File dest=new File(jsp.getParent()+"/replace/");
            if(!dest.exists())
            {
                dest.mkdirs();
            }
            File destination=new File(dest,jsp.getName());
            destination.createNewFile();
            br= new BufferedReader(  new FileReader(jsp )  );
            bw= new BufferedWriter(  new FileWriter(destination ) );
            String line = null;
               while (  (line = br.readLine()) != null) {
                   index++;
                   System.out.println(index);
                   System.out.println(line);
                   if(index<5)
                   {
                       if(line.contains("<!DOCTYPE html>"))
                       {
                           line="<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %>";
                       }else if(line.contains("<html lang=\"en\">"))
                       {
                           line="";
                       }
                   }
                   bw.write(line);
                   bw.newLine();
                   bw.flush();
               }
           index=0;
        }
        if(bw!=null)
        {
            bw.close();
        }
        if(br!=null)
        {
            br.close();
        }
    }

    private static void rename() {
        File file=new File("D:\\webProject\\taotaobootstrap\\batchRenameHtmltoJsp\\src\\pages");
        File[] files = file.listFiles(new FilenameFilter() {
           @Override
           public boolean accept(File dir, String name) {
               return new File(dir,name).isFile()&&name.endsWith(".html");
           }
       });
        //1重命名
        for (File html :
                files) {
            String orginal = html.getName();
            String destination=orginal.substring(0,orginal.lastIndexOf(".html"))+".jsp";
            File dest=new File(html.getParentFile(),destination);
            html.renameTo(dest);
        }
    }
}
