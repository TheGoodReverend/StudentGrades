/**
 *
 * @author KBowe
 */
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;


public class StudentIO 
{
    public static void addStudent(Student s, String path)
            throws IOException
            {
                File f = new File(path);
                PrintWriter out = new PrintWriter(new FileWriter(f, true));
                
                out.println(s.toString());
                out.close();
            }
    
    public static String addStudentSer(Student s, String path)
    {
        String msg = "";
        boolean needheader = true;
        
        ArrayList<Student> slist = getStudentsSer(path);
        if(!slist.isEmpty())
        {
            needheader = false;
        }
        
        try
        {
            FileOutputStream fos = new FileOutputStream(path, true);
            ObjectOutputStream oos;
            
            if(needheader)
            {
                oos = new ObjectOutputStream(fos);
            }
            else
            {
                oos = new ObjectOutputStreamNoHeader(fos);
            }
            //oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
            fos.close();
        }
        catch(NotSerializableException e)
        {
            msg = "Not serializable: " + e.getMessage();
        }
        catch(IOException e)
        {
            msg = "Serial IO Exception: " + e.getMessage();
        }
        return msg;
    }
    
    public static ArrayList<Student> getStudents(String path)
            throws IOException
            {
                ArrayList<Student> slist = new ArrayList<>();
                
                BufferedReader in = new BufferedReader(new FileReader(path));
                
                String s;
                
                s = in.readLine();
                while(s !=null)
                {
                    Student st = parseToStudent(s);
                    if(st !=null)
                    {
                        slist.add(st);
                        s = in.readLine();
                    }
                }
                in.close();
                return slist;
            }
    
    private static Student parseToStudent(String s)
    {
        //string to student process
        Student st = null;
        
        try
        {
            String[] svals = s.split(",");
            st = new Student();
            st.setSid(svals[0]);
            
            if(!svals[1].isEmpty())
            {
                st.setLname(svals[1]);
            }
            if(!svals[2].isEmpty())
            {
                st.setFname(svals[2]);
            }
            if(!svals[3].isEmpty())
            {
                st.setQ1(Double.parseDouble(svals[3]));
            }
            if(!svals[4].isEmpty())
            {
                st.setQ2(Double.parseDouble(svals[4]));
            }
            if(!svals[5].isEmpty())
            {
                st.setQ3(Double.parseDouble(svals[5]));
            }
            if(!svals[6].isEmpty())
            {
                st.setQ4(Double.parseDouble(svals[6]));
            }
            if(!svals[7].isEmpty())
            {
                st.setQ5(Double.parseDouble(svals[7]));
            }
            if(!svals[8].isEmpty())
            {
                st.setQm(Double.parseDouble(svals[8]));
            }
            if(!svals[9].isEmpty())
            {
                st.setQa(Double.parseDouble(svals[9]));
            }
            if(!svals[10].isEmpty())
            {
                st.setPr(Double.parseDouble(svals[10]));
            }
            if(!svals[11].isEmpty())
            {
                st.setMt(Double.parseDouble(svals[11]));
            }
            if(!svals[12].isEmpty())
            {
                st.setFe(Double.parseDouble(svals[12]));
            }
        }
        catch(Exception e)
        {
            st = null;
        }
        
        return st;
    }//end stud parse


    public static ArrayList<Student> getStudentsSer(String path)
    {
        ArrayList<Student> slist = new ArrayList<>();
        
        try
        {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true)
            {
                Student st = (Student) ois.readObject();
                if(st!=null)
                {
                    slist.add(st);
                }
                else
                {
                    break;
                }
            }
            ois.close();
            fis.close();
        }
        catch(Exception e)
        {
            
        }
        return slist;
    }


}//end class
