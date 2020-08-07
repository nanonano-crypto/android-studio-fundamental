package com.juara.android_fundamental;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OrderDroidCafeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //time picker
    private TimePickerDialog timePickerDialog;

    //dekalarasi calender
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private ImageView imgCal, imgJam;

    private static final String TAG = "maam" ;
    private EditText nama, alamat, phone, note, tanggal, jam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_droid_cafe);
        setTitle("order");

        nama = findViewById(R.id.et_nama);
        alamat = findViewById(R.id.et_alamat);
        phone = findViewById(R.id.et_phone);
        note = findViewById(R.id.et_note);
        imgCal = findViewById(R.id.img_cal);
        tanggal = findViewById(R.id.et_tanggal);
        jam = findViewById(R.id.et_jam);
        imgJam = findViewById(R.id.img_jam);

        //jam
        imgJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });

        //celendar
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        imgCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        //cek et_phone
        if (phone != null){
            phone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND){
                        dialNumber();
                        handled = true;
                    }
                    return handled;
                }
            });
        }

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    //method jam
    private void showTimeDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                jam.setText(+hourOfDay+":"+minute);
            }
        },
                hour, minute, true);
        timePickerDialog.show();
    }

    //method show calendar
    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tanggal.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    //method dialNumber
    private void dialNumber() {
        String phoneNum = null;

        if (phone != null) phoneNum = "tell" + phone.getText().toString();

        Log.d(TAG, "dialNumber: " + phoneNum);
        // Specify the intent.
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number.
        intent.setData(Uri.parse(phoneNum));
        // If the intent resolves to a package (app),
        // start the activity with the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextDay:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break; 
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int
            i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    //menambahkan main app ke halaman orderdroid activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    // method isi dari main app
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.order:
                displayToast(getString(R.string.action_order_message));
                return true;
            case R.id.status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.favorite:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            case R.id.jam:
                displayToast(getString(R.string.action_like_message));
                return true;
            case R.id.cart:
                displayToast(getString(R.string.action_cart_message));
                return true;
            case R.id.start:
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(OrderDroidCafeActivity.this);
                //set title dialog
                myAlertBuilder.setTitle("Menu start");
                //set text in dialog
                myAlertBuilder.setMessage("Click ok to Continoe, or cancel to stop");
                //add dialog button
                myAlertBuilder.setPositiveButton("OK", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User clicked OK button.
                                Toast.makeText(getApplicationContext(), "Pressed OK",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                myAlertBuilder.setNegativeButton("Cancel", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User cancelled the dialog.
                                Toast.makeText(getApplicationContext(), "Pressed Cancel",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                myAlertBuilder.show();
                default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }
}