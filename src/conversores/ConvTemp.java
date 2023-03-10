package conversores;

import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ConvTemp {
	
		
	public static void temperaturas() {
		
		System.out.println("Acesso a class: Temperaturas" );
		/* 
		   Celsius
		   Fahrenheit
		   Kelvin
		 */
		
		int continuaConv = 0;
		while (continuaConv <1) {
			continuaConv ++;
			//JOptionPane.showMessageDialog(null, "Moedas");
			String qtde = JOptionPane.showInputDialog(null, "Informe a temperatura", "Menu Temperaturas",JOptionPane.INFORMATION_MESSAGE );
			
			qtde = qtde.replace(".", "");
			qtde = qtde.replace(",", ".");
						
			String[] tempConv = { "Celsius => Fahrenheit", "Fahrenheit => Celsius", "Celsius => Kelvin", "Kelvin => Celsius",
					"Fahrenheit => Kelvin", "Kelvin => Fahrenheit"};
			final JComboBox<String> combo = new JComboBox<>(tempConv);
			
			String[] options = { "OK", "Cancel" };
			
			String title = "Escolha a temperatura para conversão";
			int selection = JOptionPane.showOptionDialog(null, combo, title,
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
					options[0]);
			
			Object option = combo.getSelectedItem();
			if (selection > 0) {
				System.out.println("selection is: " + options[selection]);
			} else {
				converterTemperatura(qtde, option);	
			}
			String[] options2 = { "SIM", "NÃO" };
			int option2 = JOptionPane.showOptionDialog(null, "Deseja converter mais temperaturas?", "Menu - Temperaturas", 
					0, 3, null, options2, options2[0]);
			if (option2 == 0) {
				continuaConv = 0;
			}
		}
	    // Verificar se deseja fazer outra conversão
		System.out.println("Final da conversão das temperaturas - Volta para Menu Principal do programa!");
	// Final do programa
	}

	private static void converterTemperatura(String qtde, Object option) {
		
		Double convQtde = Double.parseDouble(qtde);
					
		System.out.println("Conversão das temperaturas :\nQtde: "+ qtde+"\nTemperatura: "+option);

		if(option == "Celsius => Fahrenheit") {
			convQtde = (1.8 * convQtde) + 32;			
		}
		if(option == "Fahrenheit => Celsius") {
			convQtde = (convQtde - 32) / 1.8 ;			
		}
		if(option == "Celsius => Kelvin") {
			convQtde = convQtde + 273.15;			
		}
		if(option == "Kelvin => Celsius") {
			convQtde = (convQtde - 273.15);			
		}
		if(option == "Fahrenheit => Kelvin") {
			convQtde = (convQtde - 32) / 1.8 ;				
			convQtde = (convQtde + 273.15);		
		}
		if(option == "Kelvin => Fahrenheit") {
			convQtde = (convQtde - 273.15);		
			convQtde = (1.8 * convQtde) + 32;		
		}		
		//System.out.println("convQtde: " + convQtde);
		//System.out.println("teste : "+ new DecimalFormat(".##").format(vlrConCp));
		JOptionPane.showMessageDialog(null, "Conversão de "+ option + "\n Temperatura Convertida: "  + new DecimalFormat(".##").format(convQtde) );
		
	}
}
