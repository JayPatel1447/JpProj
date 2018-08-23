package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.awt.print.*;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller {

    @FXML
    private MenuBar Menu;

    @FXML
    private Menu File;

    @FXML
    private MenuItem Print;

    @FXML
    private Menu menu;

    @FXML
    private MenuItem CalculateTotal;

    @FXML
    private MenuItem Resetform;

    @FXML
    private MenuItem Chackout;

    @FXML
    private Menu Exit;

    @FXML
    private RadioButton None;

    @FXML
    private RadioButton radWhite;

    @FXML
    private RadioButton radWhole;

    @FXML
    private Label Qty;

    @FXML
    private TextField Txt1;

    @FXML
    private TextField Txt2;

    @FXML
    private Label Begel;

    @FXML
    private RadioButton radNoCoffee;

    @FXML
    private RadioButton radRegCoffee;

    @FXML
    private RadioButton radDouble;

    @FXML
    private RadioButton radFrench;

    @FXML
    private Label Toppings;

    @FXML
    private CheckBox chkCreamCheese;

    @FXML
    private CheckBox chkButter;

    @FXML
    private CheckBox chkBlueberry;

    @FXML
    private CheckBox chkRaspberry;

    @FXML
    private Label lblSubTotal;

    @FXML
    private Label lblTax;

    @FXML
    private Label lblTotal;

    @FXML
    private Button CaculateTotal;

    @FXML
    private Button ResetForm;

    @FXML
    private Button ChackOut;

    @FXML
    private Button Exit1;

    @FXML
    private TextField TXT1;

    @FXML
    private TextField TXT2;

    @FXML
    private TextField TXT3;

    @FXML
    private AnchorPane COF;

    @FXML
    private Button calcButton;


    private double ttotal = 0.0;
    private double ttax = ttotal * .13;
    private double stotal = ttax + ttotal;
    private MouseEvent e;

        /*
        Method calculate Total for calculating order
         */
    public void CaculateTotal(javafx.event.ActionEvent actionEvent) {
        /*
                for validation ..
         */

        boolean allTrue=true;
        try{
            if (radWhole.isSelected())
                Integer.parseInt(Txt2.getText());
            if (radWhite.isSelected())
                Integer.parseInt(Txt1.getText());
            if (radRegCoffee.isSelected())
                Integer.parseInt(TXT1.getText());
            if (radDouble.isSelected())
                Integer.parseInt(Txt2.getText());
            if (radFrench.isSelected())
                Integer.parseInt(TXT3.getText());
        }
        catch (Exception exce){
            allTrue=false;
        }
        if (allTrue) {
            if (radWhite.isSelected()) {
                ttotal += 1.25 * Integer.parseInt(Txt1.getText());

            }

            if (radWhole.isSelected()) {
                ttotal += 1.50 * Integer.parseInt(Txt2.getText());


            }

            if (None.isSelected()) {
                ttotal += 0;
                Txt2.setText("");
                Txt1.setText("");


            }

            if (radNoCoffee.isSelected()) {
                ttotal += 0;

            }

            if (radRegCoffee.isSelected()) {
                ttotal += 2.00 * Integer.parseInt(TXT1.getText());


            }

            if (radDouble.isSelected()) {
                ttotal += 2.00 * Integer.parseInt(TXT2.getText());
            }

            if (radFrench.isSelected()) {
                ttotal += 2.15 * Integer.parseInt(TXT3.getText());
            }

            if (chkCreamCheese.isSelected()) {
                ttotal += .50;
            }

            if (chkBlueberry.isSelected()) {
                ttotal += .60;
            }

            if (chkButter.isSelected()) {
                ttotal += .70;
            }

            if (chkRaspberry.isSelected()) {
                ttotal += .60;
            }

            String sttl = String.format("%.3f", ttotal);
            lblSubTotal.setText("" + sttl);
            ttax = ttotal * 0.13;
            String sub = String.format("%.3f", ttax);
            lblTax.setText("" + sub);
            stotal = ttax + ttotal;
            String stl = String.format("%.3f", stotal);
            lblTotal.setText("" + stl);

            //ttotal = 0;
            calcButton.setDisable(true);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter number");
            alert.show();
        }
            //

    }

                 /*
                Method to exit the application
                 */
    public void Exit(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }

             /*
            Method ResetForm for resetting form
             */
    public void ResetForm(javafx.event.ActionEvent actionEvent) {
        calcButton.setDisable(false);
        ttotal = 0;
        lblSubTotal.setText("" + ttotal);

        ttax = 0;
        lblTax.setText("" + ttax);

        stotal = 0;
        lblTotal.setText("" + ttotal);

        radWhite.setSelected(false);
        radWhole.setSelected(false);
        None.setSelected(false);

        radNoCoffee.setSelected(false);
        radRegCoffee.setSelected(false);
        radFrench.setSelected(false);
        radDouble.setSelected(false);

        chkRaspberry.setSelected(false);
        chkButter.setSelected(false);
        chkBlueberry.setSelected(false);
        chkCreamCheese.setSelected(false);

        chkRaspberry.setDisable(true);
        chkButter.setDisable(true);
        chkBlueberry.setDisable(true);
        chkCreamCheese.setDisable(true);
        Txt1.setText("");
        Txt2.setText("");
        TXT3.setText("");
        TXT1.setText("");
        TXT2.setText("");

    }

            /*
            Method print for print Reciept
             */
    public void print(javafx.event.ActionEvent actionEvent) {
        try {
            System.out.println("*******  Reciept Printed  *******");
            java.io.File file = new java.io.File("Reciept.txt");
            PrintWriter printWriter = new PrintWriter(file);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            printWriter.println("\t\t\t" + dateFormat.format(cal.getTime()));

            printWriter.println(" *********** SHERIDAN BAGEL STORE **********");
            System.out.println();
            System.out.println();

            printWriter.println("Items \t\t\t    Qty  \t\t\tPrice");
            printWriter.println(" -----------------------------------------");

            if (radWhite.isSelected()) {
                printWriter.println("WhiteBagel  \t\t " + Txt1.getText() + " \t\t\t\t" + (Integer.parseInt(Txt1.getText()) * 1.25));

            }

            if (radWhole.isSelected()) {
                printWriter.println("WholeBagel  \t\t" + Txt2.getText() + " \t\t\t\t" + (Integer.parseInt(Txt2.getText()) * 1.5));


            }


            if (radRegCoffee.isSelected()) {
                printWriter.println("Regular Coffee \t\t" + TXT1.getText() + "\t\t\t\t" + (Integer.parseInt(TXT1.getText()) * 2.00));
                printWriter.println("Toppings:");
            }

            if (radDouble.isSelected()) {

                printWriter.println("Double Coffee \t\t" + TXT2.getText() + "\t\t\t\t" + (Integer.parseInt(Txt2.getText()) * 2.00));
                printWriter.println("Toppings:");
            }

            if (radFrench.isSelected()) {
                printWriter.println("french Coffee \t\t" + TXT3.getText() + "\t\t\t\t" + (Integer.parseInt(TXT3.getText()) * 2.15));
                printWriter.println("Toppings:");
            }

            if (chkCreamCheese.isSelected()) {
                // ttotal += .50 ;
                printWriter.println("CreamCheese  \t\t--\t\t\t" + "    .50");
            }

            if (chkBlueberry.isSelected()) {
                // ttotal += .60;
                printWriter.println("Blueberry  \t\t\t--\t\t\t  " + "  .60");
            }

            if (chkButter.isSelected()) {
                //ttotal += .70;
                printWriter.println("Butter   \t\t\t--\t\t\t " + "   .70");
            }

            if (chkRaspberry.isSelected()) {
                //ttotal += .60;
                printWriter.println("Raspberry  \t\t\t--\t\t\t " + "   .60");
            }

            printWriter.println("\t\t\t \t------------------- \t\t\t");
            System.out.println();
            printWriter.println("\t\t\t\t\t\tSubTotal : \t" + ttotal);
            printWriter.println("\t\t\t\t\t\tTax 13%: \t" + ttax);
            printWriter.println("\t\t\t\t\t\tFinal Total:" + stotal);
            printWriter.println("************** Thank You!! Visit Again ****************");


            printWriter.flush();
            printWriter.close();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
                 /*
                Method addQty for disable function
                 */
    public void addQty(javafx.event.ActionEvent actionEvent) {


        if (radRegCoffee.isSelected()) {
            TXT1.setText("1");
        }

        if (radWhite.isSelected()) {
            Txt1.setText("1");
            Txt2.setText("");
            radRegCoffee.setDisable(false);
            radDouble.setDisable(false);
            radFrench.setDisable(false);
            radNoCoffee.setDisable(false);
            chkCreamCheese.setDisable(false);
            chkBlueberry.setDisable(false);
            chkButter.setDisable(false);
            chkRaspberry.setDisable(false);
            TXT1.setDisable(false);
            TXT2.setDisable(false);
            TXT3.setDisable(false);
        }

        if (radWhole.isSelected()) {
            Txt2.setText("1");
            Txt1.setText("");

            radRegCoffee.setDisable(false);
            radDouble.setDisable(false);
            radFrench.setDisable(false);
            radNoCoffee.setDisable(false);
            chkCreamCheese.setDisable(false);
            chkBlueberry.setDisable(false);
            chkButter.setDisable(false);
            chkRaspberry.setDisable(false);
            TXT1.setDisable(false);
            TXT2.setDisable(false);
            TXT3.setDisable(false);


        }
        if (None.isSelected()) {


            TXT1.setDisable(false);
            TXT2.setDisable(false);
            TXT3.setDisable(false);
            Txt2.setText("");
        }

        if (radDouble.isSelected()) {
            TXT2.setText("1");
            TXT1.setText("");
            TXT3.setText("");

        }

        if (radFrench.isSelected()) {
            TXT3.setText("1");
            TXT1.setText("");
            TXT2.setText("");
        }

        if (radRegCoffee.isSelected()) {
            TXT3.setText("");
            TXT1.setText("1");
            TXT2.setText("");
        }

    }


             /*
            Method print for print Reciept via printer
             */
    public void Printer(javafx.event.ActionEvent actionEvent) {

        PrinterJob printerJob =PrinterJob.getPrinterJob();
        if (printerJob.printDialog())
        {
            try
            {
                printerJob.print();
            } catch (PrinterException e1) {
                e1.printStackTrace();
            }
        }

    }
}



