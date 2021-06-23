/**
 *
 * @author KBowen
 */
package business;

import java.io.Serializable;
import java.util.Arrays;


public class Student implements Serializable
{
    //Variables passed by web app
    private String sid, lname, fname;
    private double q1, q2, q3, q4, q5, qm, mt, pr, fe;
    

    
    
    public Student()//mt const
    {
        this.sid = "";
        this.lname = "";
        this.fname = "";
        this.q1 = 0;
        this.q2 = 0;
        this.q3 = 0;
        this.q4 = 0;
        this.q5 = 0;
        //this.qa = 0;
        this.qm = 0;
        this.mt = 0;
        this.pr = 0;
        this.fe = 0;
        //this.fg = 0;
        //this.lg = "";
    }
    
    public Student(String sid, String lname, String fname, double q1, double q2, double q3, double q4, double q5, double qm, double qa, double mt, double pr, double fe)
    {
        this.sid = sid;
        this.lname = lname;
        this.fname = fname;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.qm = qm;
        //this.qa = qa;
        this.mt = mt;
        this.pr = pr;
        this.fe = fe;
        //this.fg = getFinalGrade();
        //this.lg = getLetterGrade();
    }
    
    //calculated variables for text file
    private String lg;
    private double fg;
    private double qa;
    
    public String getSid() 
    {
        return sid;
    }

    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getLname() 
    {
        return lname;
    }

    public void setLname(String lname) 
    {
        this.lname = lname;
    }

    public String getFname() 
    {
        return fname;
    }

    public void setFname(String fname) 
    {
        this.fname = fname;
    }

    public double getQ1() 
    {
        return q1;
    }

    public void setQ1(double q1) 
    {
        this.q1 = q1;
    }

    public double getQ2() 
    {
        return q2;
    }

    public void setQ2(double q2) 
    {
        this.q2 = q2;
    }

    public double getQ3() 
    {
        return q3;
    }

    public void setQ3(double q3) 
    {
        this.q3 = q3;
    }

    public double getQ4() 
    {
        return q4;
    }

    public void setQ4(double q4) 
    {
        this.q4 = q4;
    }

    public double getQ5() 
    {
        return q5;
    }

    public void setQ5(double q5) 
    {
        this.q5 = q5;
    }

    public double getQm() 
    {
        return qm;
    }

    public void setQm(double qm) 
    {
        this.qm = qm;
    }
	
    public double getMt() 
    {
        return mt;
    }

    public void setMt(double mt) 
    {
        this.mt = mt;
    }

    public double getPr() 
    {
        return pr;
    }

    public void setPr(double pr) 
    {
        this.pr = pr;
    }

    public double getFe() 
    {
        return fe;
    }

    public void setFe(double fe) 
    {
        this.fe = fe;
    }

    public double getQuizAvg() 
    {
        double [] q = {this.q1, this.q2, this.q3, this.q4, this.q5, this.qm};
		Arrays.sort(q);
        
	this.qa = (q[2] + q[3] + q[4] + q[5]) /4;
	return this.qa;
    }
    
    
    public void setQa(double qa)
    {
        this.qa = qa;
    }
    
    public double getFinalGrade()
    {
        double qavg = this.qa * 0.50; 
        double midTerm = this.mt * 0.15;
        double probs = this.pr * 0.10;
        double finEx = this.fe * 0.25;
        double simpleAvg = (this.qa + this.mt + this.pr)/3;
        
        //this.fg = 0;
        
        if(simpleAvg >= 90)
        {
            this.fg = simpleAvg;
        }
        else if(simpleAvg < 90)
        {
            this.fg = (qavg + midTerm + probs + finEx);
        }
        
        return this.fg;
    }
    
//    public void setFg(double fg)
//    {
//        this.fg = getFinalGrade();
//    }
    
    public String getLetterGrade()
    {
        double gradeFinal = this.fg;
        
        if(gradeFinal >= 90)
        {
            this.lg = "A";
        }
        else if(gradeFinal < 90 && gradeFinal >=80)
        {
            this.lg = "B";
        }
        else if(gradeFinal < 80 && gradeFinal >=70)
        {
            this.lg = "C";
        }
        else if(gradeFinal < 70 && gradeFinal >=60)
        {
            this.lg = "D";
        }
        else if(gradeFinal <60 )
        {
            this.lg = "Zoinks";
        }
        else 
        {
            this.lg = "Error in Letter Grade method";
        }
        
        return this.lg;        
        
    }
    
//    public void setLg(String lg)
//    {
//        this.lg = getLetterGrade();
//    }
    
    @Override
    public String toString()
    {
        return 
                this.sid + "," + this.lname + "," + this.fname + "," + this.q1 + "," + this.q2 + "," + 
                this.q3  + "," + this.q4    + "," + this.q5    + "," + this.qm + "," + getQuizAvg() + "," + 
                this.pr  + "," + this.mt    + "," + this.fe    + "," + getFinalGrade() + "," + getLetterGrade();
        
    }
    
    //sval 0 = sid
    //sval 1 = lname
    //sval 2 = fname
    //sval 3 = 1
    //sval 4 = 2
    //sval 5 = 3
    //sval 6 = 4
    //sval 7 = 5
    //sval 8 = makeup
    //sval 9 = average
    //sval 10 = problems
    //sval 11 = mid term
    //sval 12 = final exam
    //sval 13 = final grade
    //sval 14 = letter grade
    
}
    
 

