package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import weareSupports.BDlocal;

public class TablaStats extends JFrame{
	
	JTable tabla;
	BDlocal bd = new BDlocal();
	Modelo modelo;
	MiRenderer renderer;
	DefaultTableModel mDatos;
	
	TreeMap<String, Integer> mapa; 
	ArrayList<String> players;
	String[] columnNames = {"Username","Gems" };
	Object[][]data = {{"ey","123"}};
	 Connection c = null;
     Statement stmt = null;

     public static <K, V extends Comparable<V>> Map<K, V> 
     sortByValues(final Map<K, V> map) {
     Comparator<K> valueComparator = 
              new Comparator<K>() {
       public int compare(K k1, K k2) {
         int compare = 
               map.get(k1).compareTo(map.get(k2));
         if (compare == 0) 
           return 1;
         else 
           return compare;
       }
     };
  
     Map<K, V> sortedByValues = 
       new TreeMap<K, V>(Collections.reverseOrder(valueComparator));
     sortedByValues.putAll(map);
        return sortedByValues;
   }
     
	public TablaStats() {
		
		
		players = new ArrayList<>();
		mapa = new TreeMap<String, Integer>();
		
		
		try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:Towers2.0.db");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();
	          ResultSet rs = stmt.executeQuery( "SELECT NAME_P,GEMS FROM PLAYERS;" );
	          
	          while ( rs.next() ) {
	             
	             String  name = rs.getString("NAME_P");
	             String  gems = rs.getString("GEMS");
	             mapa.put(name, Integer.parseInt(gems));
	            
	          }
	          rs.close();
	          stmt.close();
	          c.close();
	       } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Operation done successfully");
	      
	       
	      
	     

	       
	       
	       
	       mDatos = new DefaultTableModel() {
				{ setColumnIdentifiers( new Object[] { "USERNAME", "GEMS" } ); }  // Inicialización para que salgan solo las cabeceras cuando la tabla está vacía al principio
				@Override
				public void setValueAt(Object aValue, int row, int column) {
					
						super.setValueAt(aValue, row, column);
						
						
					
				}
				 public boolean isCellEditable(int rowIndex, int columnIndex) {
		    	    	
		    	    		return false;
		    	    }
			};
	       
	       
			
			
			 Map sortedMap = sortByValues(mapa);
			 
		       
		       // Get a set of the entries on the sorted map
		       Set set = sortedMap.entrySet();
		    
		       // Get an iterator
		       Iterator i = set.iterator();
		    
		     
		       while(i.hasNext()) {
		         Map.Entry me = (Map.Entry)i.next();
		         
		         mDatos.addRow(new Object[]{me.getKey(), me.getValue()});
		        
		       }
	       

		       
	       modelo = new Modelo();
	       renderer = new MiRenderer();
	       tabla = new JTable(mDatos);
	       tabla.getColumnModel().getColumn(1).setCellRenderer(renderer);
	       tabla.getColumnModel().getColumn(0).setCellRenderer(renderer);
	       tabla.setRowHeight(30);
	       tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 23));
	       tabla.getTableHeader().setPreferredSize(new Dimension(100,40));
	       JScrollPane sp = new JScrollPane(tabla);

	       
	       
	       this.add(sp);
	       setSize(600,700);
	       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	       setLocationRelativeTo(null);
	       setVisible(true);
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
		
	}
	
	
	class Modelo extends DefaultTableModel  {
		
		public String getColumnName(int col) {
	        return columnNames[col].toString();
	    }
	    public int getRowCount() { return data.length; }
	    public int getColumnCount() { return columnNames.length; }
	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }
	    public boolean isCellEditable(int row, int col) {
	        return false; }
	    
	    public void setValueAt(Object value, int row, int col) {
	        data[row][col] = value;
	        
	        for (String key :mapa.keySet()) {
	        	 //this.addRow(key);
	        	
	        }
	       
	        
	        fireTableCellUpdated(row, col);
	    }
		
	}


	
	class MiRenderer extends DefaultTableCellRenderer{
		
		public MiRenderer() { super(); }
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	    	      boolean hasFocus, int rowIndex, int vColIndex) {
	    	
			
			

	    	    setText(value.toString());
	    	    Integer status = (Integer)table.getModel().getValueAt(rowIndex, 1);
	    	    
	    	    if (rowIndex == 0) {
	    	    	setBackground(Color.yellow);
	                setForeground(Color.BLACK);
	                setFont(new java.awt.Font("Verdana", Font.BOLD, 16));
	            	return this;
	            }
	    	    if (rowIndex == 1) {
	    	    	setBackground(Color.gray);
	                setForeground(Color.BLACK);
	            	return this;
	            }
	    	   
	            if (status == 0) {
	                setBackground(Color.red);
	                setForeground(Color.WHITE);
	                return this;
	           
	            }else {
	            	setBackground(Color.white);
	                setForeground(Color.black); 
	                return this;
	            }
	           
	           
		}
	}
	
	public static void main(String[] args) {
		
		new TablaStats();
	}
}
