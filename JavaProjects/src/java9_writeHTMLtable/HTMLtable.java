package java9_writeHTMLtable;
import java.io.*; 
public class HTMLtable {
	public static void main(String[] args)
    {
        try {
            //define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
            
            Object[] col = {"Column01","Column02","Column03"};
            Object[][] input = {{"X","Y","Z"},{1,2,3},
            {"<a href=\"https://www.imagediamond.com/blog/good-morning-images-nature/\"><img src=\"https://www.imagediamond.com/blog/wp-content/uploads/2019/11/Good-Morning-nature-5.jpg\""+
                    " height=\"20\" width=\"20\"></a>","<a href=\"https://www.imagediamond.com/blog/good-morning-images-nature/\"><img src=\"https://www.imagediamond.com/blog/wp-content/uploads/2019/11/Good-Morning-3-2.jpg\""+
                            " height=\"20\" width=\"20\"></a>",0}};
            
            //append html header and title
            htmlStringBuilder.append("<html><head><title>HTML Table</title>");
            
            //append style & border
            //htmlStringBuilder.append("<style>table{border-collapse:collapse;width: 100%;}th,td{border: 2px solid blue;padding: 10px;}</style></head>");
            htmlStringBuilder.append("<style>" +   
            "table{" +  
                "border-collapse: collapse;" +  
                "width: 100%;" +   
               "}" + 
            "th,td{" +  
                  "border: 2px solid blue;" +
                  "padding: 10px;" +  
                "}" + 
            "</style>" +  
            "</head>");  
            
            //append body
            htmlStringBuilder.append("<body>");
            
            //append table with header
            htmlStringBuilder.append("<table><tr><th><b>"+col[0]+"</b></th><th><b>"+col[1]+"</b></th><th><b>"+col[2]+"</b></th></tr>");
            for (int i = 0; i < input.length; i++) 
              { 
            //append details/image row
                htmlStringBuilder.append("<tr><td>"+input[i][0]+"</td><td>"+input[i][1]+"</td><td>"+input[i][2]+"</td></tr>");
              }
            
            //close html file
            htmlStringBuilder.append("</table></body></html>");
            
            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),"testfile.html");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void WriteToFile(String fileContent, String fileName) throws IOException {
        
    	String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator+fileName;
        
        File file = new File(tempFile);
        
        // if file exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator+ "backup_"+fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }
}
	
