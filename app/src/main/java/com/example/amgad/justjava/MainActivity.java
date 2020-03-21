/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.amgad.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int Quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();
        EditText ename = (EditText) findViewById(R.id.name_editText);
        String name = ename.getText().toString();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String summary = createOrderSummary(price,hasWhippedCream,hasChocolate,name);
        displayMessage(summary);
    }
    public String createOrderSummary(int price,boolean hasWhippedCream,boolean hasChocolate,String name){
        String priceMessage = "Name: "+name;
        priceMessage += "\nadd whipped Cream= "+hasWhippedCream;
        priceMessage += "\nadd chocolate= "+hasChocolate;
        priceMessage += "\nQuantity= "+Quantity;
        priceMessage += "\nTotal= $"+price;
        priceMessage += "\nthank you!";
        return priceMessage;
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (Quantity == 100) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        Quantity = Quantity + 1;
        displayQuantity(Quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (Quantity == 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        Quantity = Quantity - 1;
        displayQuantity(Quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(boolean hasWhippedCream,boolean hasChocolate) {
        int basePrice = 5;
        if(hasWhippedCream){
            basePrice += 1;
        }
        if(hasWhippedCream){
            basePrice += 1;
        }
        return Quantity * basePrice;
    }
}