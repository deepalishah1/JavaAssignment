package com.UI;
import com.Impl.StudentServiceImp;
import com.model.Student;

import java.awt.*;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Checkbox;



public class StudentUI extends Frame implements WindowListener{
	
	int tef1,tef2,tef3;
	TextField tfrollno,tfname,tfaddress,tfmarks;
	Label l1rollno,l2name,l3address,l4marks,l5age,l6gender; 
	Button save,update,delete,search,first,next,previous,last;
	Checkbox cb1, cb2;
	String option;
	int  ch;
	
	public StudentUI(String title) {
	setBounds(100,100, 800, 600);
	setVisible(true);
	setTitle(title);
	setLayout(null);
	 
	tfrollno = new TextField();	 
	tfrollno.setBounds(100, 100, 100, 25);
	tfname = new TextField();
	tfname.setBounds(100,130,100,25);
	tfaddress = new TextField();
	tfaddress.setBounds(100,170,150,40);
	tfmarks = new TextField();
	tfmarks.setBounds(100,220,100,25);
	
	l1rollno=new Label("Roll No:");  
    l1rollno.setBounds(20,100,80, 25);  	
	l2name=new Label("Name:");  
    l2name.setBounds(20,130,80,25);  
	l3address=new Label("Address:");  
    l3address.setBounds(20,180,80,25);  
	l4marks=new Label("Marks:");  
    l4marks.setBounds(20,220,80,25); 
	l5age=new Label("Age:");  
    l5age.setBounds(20,270,80,25); 
    l6gender=new Label("Gender:");  
    l6gender.setBounds(20,320,80,25); 
	
	save = new Button("Save");
	save.setBounds(100, 400, 100, 25);
	update = new Button("Update");
	update.setBounds(300, 400, 100, 25);
	delete = new Button("Delete");
	delete.setBounds(500, 400, 100, 25);
	search = new Button("Search");
	search.setBounds(700, 400, 100, 25);
	first = new Button("First");
	first.setBounds(100, 450, 100, 25);
	next = new Button("next");
	next.setBounds(300, 450, 100, 25);
	previous = new Button("previous");
	previous.setBounds(500, 450, 100, 25);
	last = new Button("last");
	last.setBounds(700, 450, 100, 25);
	 
	 Choice age = new Choice();
     age.setBounds(100, 270,100,25);
     age.addItemListener(new ItemListener() {  
         public void itemStateChanged(ItemEvent e) {               
            ch = Integer.parseInt(age.getSelectedItem()); 
         }  
      }); 
     
     
	   CheckboxGroup cbg1=new CheckboxGroup();
	     cb1=new Checkbox ("F", cbg1, false); 
	     cb1.setBounds(100,320, 100,25);
	     
	     cb2=new Checkbox ("M", cbg1, false);
	     cb2.setBounds(220,320,100,25);
	     cb1.addItemListener(new ItemListener() {  
	            public void itemStateChanged(ItemEvent e) {               
	               option = "F";  
	            }  
	         });  
	        cb2.addItemListener(new ItemListener() {  
	            public void itemStateChanged(ItemEvent e) {               
	            	option = "M";  
	            }  
	         });  
	       
	       	
	add(tfrollno);
	add(tfname);
	add(tfaddress);
	add(tfmarks);
	
	add(l1rollno);
	add(l2name);
	add(l3address);
	add(l4marks);
	add(l5age);
	add(l6gender);
	
    age.add("22");
    age.add("23");
    age.add("24");
    age.add("25");
    add(age);
    add(cb1);
    add(cb2);
    
	add(save);
	add(update);
	add(delete);
	add(search);
	add(first);
	add(next);
	add(previous);
	add(last);
	
	
	save.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			 StudentServiceImp si = new StudentServiceImp();
			 Student s = new Student(Integer.parseInt(tfrollno.getText()),tfname.getText(),tfaddress.getText(),Integer.parseInt(tfmarks.getText()),ch,option);
			 si.Save(s);
		}
	});

	update.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			 StudentServiceImp si = new StudentServiceImp();
			 Student s = new Student(Integer.parseInt(tfrollno.getText()),tfname.getText(),tfaddress.getText(),Integer.parseInt(tfmarks.getText()),ch,option);
			 si.Update(s);
		}
	});

	delete.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			 StudentServiceImp si = new StudentServiceImp();
			 si.Delete(Integer.parseInt(tfrollno.getText()));
		}
	});
	
	search.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			 Student result;
			 StudentServiceImp si = new StudentServiceImp();
			 result = si.Search(Integer.parseInt(tfrollno.getText()));
		     tfname.setText(result.getName());
		     tfaddress.setText(result.getAddress());
		     tfmarks.setText(Integer.toString(result.getMark()));
             age.select(Integer.toString(result.getAge()));
		     String gen = result.getGender();
		     if(gen.compareTo("F")==0)
		    	 cbg1.setSelectedCheckbox(cb1);
		     else
		    	 cbg1.setSelectedCheckbox(cb2);
		     
		}
	});
	
	first.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			 Student result;
			 StudentServiceImp si = new StudentServiceImp();
			 result = si.First();
			 tfrollno.setText(Integer.toString(result.getRollno()));
			 tfname.setText(result.getName());
		     tfaddress.setText(result.getAddress());
		     tfmarks.setText(Integer.toString(result.getMark()));
		     
		}
	});
	
	next.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			 Student result;
			 StudentServiceImp si = new StudentServiceImp();
			 int rollno =Integer.parseInt(tfrollno.getText());
			 result = si.Next(rollno);
			 tfrollno.setText(Integer.toString(result.getRollno()));
			 tfname.setText(result.getName());
		     tfaddress.setText(result.getAddress());
		     tfmarks.setText(Integer.toString(result.getMark()));
		     
		}
	});	
		
	previous.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			 Student result;
			 StudentServiceImp si = new StudentServiceImp();
			 int rollno =Integer.parseInt(tfrollno.getText());
			 result = si.Prev(rollno);
			 tfrollno.setText(Integer.toString(result.getRollno()));
			 tfname.setText(result.getName());
		     tfaddress.setText(result.getAddress());
		     tfmarks.setText(Integer.toString(result.getMark())); 
		     
		}
	});
	
	last.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){	
			Student result;
			 StudentServiceImp si = new StudentServiceImp();
			 result  = si.Last();
		     tfrollno.setText(Integer.toString(result.getRollno()));
			 tfname.setText(result.getName());
		     tfaddress.setText(result.getAddress());
		     tfmarks.setText(Integer.toString(result.getMark()));
		     
		}
	});

	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		   StudentUI myfrm = (StudentUI) arg0.getSource();
		    myfrm.dispose();		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}