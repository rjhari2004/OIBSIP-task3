import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//R J HARI
public class atm {
    static ArrayList<String>[] details=new ArrayList[50];
    static LinkedHashMap<String,String> users=new LinkedHashMap<>();
    static float[] bal=new float[50];
    static int k=0;
    public static int getindex(String u){
        Set<String> l=users.keySet();
        System.out.println(l);
        Object[] array = l.toArray();
        int c=0;
        for(int i=0;i<l.size();i++)
        {
            System.out.println(array[i]);
            if (array[i].toString().equals(u)){
                //System.out.println("Hi");
            c=i;
            }
        }
        return c;
    }
    static class withdraw{
    withdraw(int userno){
        JFrame with=new JFrame();
        with.getContentPane().setBackground(Color.CYAN);
        with.setSize(500,500);
        with.setResizable(false);
        Label b=new Label("Balance :"+bal[userno]);
        b.setBounds(40,50,350,50);
        b.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(b);

        Label l=new Label("Enter the amount that you want to withdraw :");
        l.setBounds(40,100,350,50);
        l.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(l);

        TextField t=new TextField();
        t.setBounds(100,150,150,30);
        with.add(t);

        Button sub=new Button("Submit");
        sub.setBounds(100,200,150,30);
        with.add(sub);

        Label l1=new Label(" ");
        l1.setBounds(40,250,1000,150);
        l1.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(l1);

        Label waste=new Label(" ");
        with.add(waste);

        with.setVisible(true);

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                float cash=Float.parseFloat(t.getText());
                if(cash>bal[userno]){
                    l1.setText("The amount to be withdrawn greater than balance");
                }
                else{
                    bal[userno]=bal[userno]-cash;
                    b.setText("Balance :"+bal[userno]);
                    l1.setText(" ");
                    details[userno].add(cash+" debited");
                }
            }
        });
    }
}
    static class deposit{
        deposit(int userno){
        JFrame with=new JFrame();
        with.getContentPane().setBackground(Color.CYAN);
        with.setSize(500,500);
        with.setResizable(false);
        Label b=new Label("Balance :"+bal[userno]);
        b.setBounds(40,50,350,50);
        b.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(b);

        Label l=new Label("Enter the amount that you want to deposit :");
        l.setBounds(40,100,350,50);
        l.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(l);

        TextField t=new TextField();
        t.setBounds(100,150,150,30);
        with.add(t);

        Button sub=new Button("Submit");
        sub.setBounds(100,200,150,30);
        with.add(sub);

        Label l1=new Label(" ");
        l1.setBounds(40,250,1000,150);
        l1.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(l1);

        Label waste=new Label(" ");
        with.add(waste);

        with.setVisible(true);

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                float cash=Float.parseFloat(t.getText());
                bal[userno]=bal[userno]+cash;
                b.setText("Balance :"+bal[userno]);
                l1.setText(" ");
                details[userno].add(cash+" credited");
            }
        });
    }
}
    static class transfer{
        transfer(int userno){
            JFrame with=new JFrame();
        with.getContentPane().setBackground(Color.CYAN);
        with.setSize(500,500);
        with.setResizable(false);
        Label b=new Label("Balance :"+bal[userno]);
        b.setBounds(40,50,350,50);
        b.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(b);

        Label l=new Label("Enter the amount that you want to transfer :");
        l.setBounds(40,100,350,50);
        l.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(l);

        TextField t=new TextField();
        t.setBounds(100,150,150,30);
        with.add(t);

        Label l2=new Label("Enter the account number to which you want to transfer :");
        l2.setBounds(40,200,350,50);
        l2.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(l2);

        TextField t2=new TextField();
        t2.setBounds(100,250,150,30);
        with.add(t2);
        
        Button sub=new Button("Submit");
        sub.setBounds(100,300,150,30);
        with.add(sub);

        Label l1=new Label(" ");
        l1.setBounds(40,350,1000,150);
        l1.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.add(l1);

        Label waste=new Label(" ");
        with.add(waste);

        with.setVisible(true);

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                float cash=Float.parseFloat(t.getText());
                if(cash>bal[userno]){
                    l1.setText("The amount to be transferred greater than balance");
                }
                else if(cash>50000){
                    l1.setText("Transfer limit is 50000");
                }
                else{
                    bal[userno]=bal[userno]-cash;
                    b.setText("Balance :"+bal[userno]);
                    l1.setText("Successfully transferred");
                    details[userno].add(cash+" successfully transferred to account number "+t2.getText());
                }
            }
        });
        }
    }
    static class quit{
        quit(int userno){
            

        }
    }

    static class transacthistory{
        transacthistory(int userno){
            JFrame his=new JFrame();
            his.getContentPane().setBackground(Color.CYAN);
            his.setSize(500,500);
            his.setResizable(false);
            Label b=new Label("Balance :"+bal[userno]);
            b.setBounds(40,50,350,50);
            b.setFont(new Font("Times New Roman",Font.BOLD,15));
            his.add(b);

            JLabel c[]=new JLabel[details[userno].size()];
            int m=100;
            for(int i=details[userno].size();i>0;i--){
                c[details[userno].size()-i]=new JLabel(details[userno].get(i-1));
                c[details[userno].size()-i].setBounds(40,m,350,50);
                his.add(c[details[userno].size()-i]);
                m=m+50;
            }

            Label waste=new Label(" ");
            his.add(waste);

            his.setVisible(true);
        }
    }
    public static void outside(){
        JFrame out=new JFrame();
        
        out.getContentPane().setBackground(Color.CYAN);
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        out.setSize(440,300);
        out.setResizable(false);

        Label head=new Label("ATM INTERFACE");
        head.setFont(new Font("Algerian",Font.BOLD,25));
        head.setBounds(100,50,350,50);
        out.add(head);

        Button th=new Button("Login");
        th.setFont(new Font("Times New Roman",Font.BOLD,15));
        th.setBounds(40,100,350,50);
        out.add(th);

        Button with=new Button("Register");
        with.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.setBounds(40,150,350,50);
        out.add(with);

        Label waste=new Label(" ");
        out.add(waste);
        out.setVisible(true);
        th.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                out.setVisible(false);
                login();
            }
        });

        with.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                out.setVisible(false);
                register();
            }
        });

    }
    public static void register(){
        JFrame reg=new JFrame();
        reg.setSize(400,400);
        reg.setResizable(false);
        reg.getContentPane().setBackground(Color.CYAN);
        Label l1=new Label();
        l1.setText("User Id :");
        l1.setBounds(40,50,350,50);
        reg.add(l1);

        TextField id=new TextField();
        id.setBounds(100, 100, 150,30);
        reg.add(id);
        
        Label l2=new Label();
        l2.setText("User Pin :");
        l2.setBounds(40,150,150,30);
        reg.add(l2);

        TextField pin=new TextField();
        pin.setBounds(100, 200, 150,30);
        reg.add(pin);

        Button log=new Button("Register");
        log.setBounds(150,250,150,30);
        reg.add(log);

        Label l3=new Label();
        l3.setText(" ");
        l3.setBounds(100,300,150,30);
        reg.add(l3);
        
        Label l4=new Label(" ");
        reg.add(l4);
        l1.setFont(new Font("Times New Roman",Font.BOLD,15));
        l2.setFont(new Font("Times New Roman",Font.BOLD,15));
        reg.setVisible(true);

        log.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                users.put(id.getText(),pin.getText());
                l3.setText("Registration Successful");
                reg.setVisible(false);
                outside();
            }
        });
    }
    public static void login(){
        JFrame login=new JFrame();
        login.setSize(400,400);
        login.setResizable(false);
        login.getContentPane().setBackground(Color.CYAN);
        Label l1=new Label();
        l1.setText("User Id :");
        l1.setBounds(40,50,350,50);
        login.add(l1);

        TextField id=new TextField();
        id.setBounds(100, 100, 150,30);
        login.add(id);
        
        Label l2=new Label();
        l2.setText("User Pin :");
        l2.setBounds(40,150,150,30);
        login.add(l2);

        TextField pin=new TextField();
        pin.setBounds(100, 200, 150,30);
        login.add(pin);

        Button log=new Button("Login");
        log.setBounds(150,250,150,30);
        login.add(log);

        Label l3=new Label();
        l3.setText(" ");
        l3.setBounds(100,300,150,30);
        login.add(l3);
        
        Label l4=new Label(" ");
        login.add(l4);
        l1.setFont(new Font("Times New Roman",Font.BOLD,15));
        l2.setFont(new Font("Times New Roman",Font.BOLD,15));
        login.setVisible(true);

        log.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(users.containsKey(id.getText())){
                if(users.get(id.getText()).equals(pin.getText()))
                {
                    login.setVisible(false);
                    inside(id.getText());
                }
                else{
                    l3.setText("Wrong credentials");
                }
            }
                else{
                l3.setText("Wrong credentials");
                }
            }
        });
    }
    public static void inside(String u){
        System.out.println(users);
        for(int i=0;i<50;i++){
        System.out.println(bal[i]);}
        System.out.println(u);
        int userno=getindex(u);
        System.out.println(userno);
        JFrame inside=new JFrame();
        inside.getContentPane().setBackground(Color.CYAN);
        inside.setSize(500,500);
        inside.setResizable(false);

        Button th=new Button("Transaction History");
        th.setFont(new Font("Times New Roman",Font.BOLD,15));
        th.setBounds(40,100,350,50);

        Button with=new Button("Withdraw");
        with.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.setBounds(40,150,350,50);
        
        Button dep=new Button("Deposit");
        dep.setFont(new Font("Times New Roman",Font.BOLD,15));
        dep.setBounds(40,200,350,50);

        Button tr=new Button("Transfer");
        tr.setFont(new Font("Times New Roman",Font.BOLD,15));
        tr.setBounds(40,250,350,50);

        Button quit=new Button("Quit");
        quit.setFont(new Font("Times New Roman",Font.BOLD,15));
        quit.setBounds(40,300,350,50);

        Label waste=new Label(" ");

        inside.add(th);
        inside.add(with);
        inside.add(dep);
        inside.add(tr);
        inside.add(quit);
        inside.add(waste);
        inside.setVisible(true);

        th.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                transacthistory thw=new transacthistory(userno);
            }
        });

        with.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                withdraw w=new withdraw(userno);
            }
        });

        dep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                deposit d=new deposit(userno);
            }
        });

        tr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                transfer tt=new transfer(userno);
            }
        });

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame quits=new JFrame();
            quits.getContentPane().setBackground(Color.CYAN);
            quits.setSize(500,300);
            quits.setResizable(false);
            Label l1=new Label("Are you sure you want to Log out ?");
            l1.setBounds(40,50,500,50);
            l1.setFont(new Font("Times New Roman",Font.BOLD,15));
            quits.add(l1);
        Button th=new Button("Yes");
        th.setFont(new Font("Times New Roman",Font.BOLD,15));
        th.setBounds(40,100,350,50);
        quits.add(th);

        Button with=new Button("No");
        with.setFont(new Font("Times New Roman",Font.BOLD,15));
        with.setBounds(40,150,350,50);
        quits.add(with);

        Label waste=new Label(" ");
        quits.add(waste);
        quits.setVisible(true);
        th.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                quits.setVisible(false);
                inside.setVisible(false);
                outside();
            }
        });

        with.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                quits.setVisible(false);
                
            }
        });

                //quit q=new quit(userno);
            }
        });
    }
    public static void main(String[] args) {
        //users.put("Hari","1234");
        for(int i=0;i<50;i++)
        {
            bal[i]=500;
            details[i]=new ArrayList<String>();
        }
        //System.out.println(bal);
        //System.out.println(users);
        outside();
    }
}
