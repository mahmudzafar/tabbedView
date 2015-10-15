package com.example.halfm_1.tabbedview;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.net.URI;

public class tab1 extends android.support.v4.app.Fragment implements View.OnClickListener{
    @Nullable

    Uri contactInfo;
    URI contactinfo;
   Context c;
    static  String []phone;
    static String []name;
    static int []type;
    TableLayout tl;
    TableRow tr;
    TextView nameView;
    TextView phoneView;
    int Contactscount=0;
    int count=0;
    Cursor cursor;
    Button searchBtn;
    View.OnClickListener listener;
   EditText edit;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        cursor = activity.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        c=activity;




    }
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
       c=getActivity();
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_tab1, container, false);
edit=(EditText)view.findViewById(R.id.editText);

        searchBtn=(Button)view.findViewById(R.id.new_btn);
        //searchBtn.setOnClickListener(listener);
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Log.e("string", name[4]);
                Log.e("string", "sads");
               // switch(v.getId()) {
                  //  case R.id.new_btn:
                        Log.e("string", name[4]);
                        EditText e = (EditText) getActivity().findViewById(R.id.editText);
                        String sub = e.getText().toString();


                        tl.removeAllViews();
                        for (int i = 0; i < Contactscount; i++) {

                            if (name[i] != "" && name[i] != null) {
                                if (name[i].toLowerCase().contains(sub.toLowerCase())) {
                                    Log.e("string", name[i]);
                                    Log.e("Sub", sub);
                                    tr = new TableRow(getActivity());
                                    tr.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT));
                                    nameView = new TextView(getActivity());

                                    nameView.setText(name[i]);
                                    nameView.setHeight(40);
                                    nameView.setTextSize(16);
                                    nameView.setPadding(20, 15, 0, 0);


                                    tr.addView(nameView);


                                    phoneView = new TextView(getActivity());
                                    phoneView.setText(phone[i]);
                                    phoneView.setPadding(0, 15, 10, 0);
                                    //phoneView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                                    phoneView.setTextSize(16);

                                  //  phoneView.setTextSize(18);
                                    tr.addView(phoneView);
                                    tl.addView(tr, new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT, ScrollView.LayoutParams.MATCH_PARENT));

                                    View v = new View(c);
                                    v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
                                    v.setBackgroundColor(Color.rgb(51, 51, 51));
                                    tl.addView(v);
                                }
                            }

                        }


                        Log.e("string", name[4]);
                     //   break;
              //  }
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });
searchBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    }
});





        ReadPhoneContacts(c);
        // Display();
        // Log.e(name[1], "contact name--!!!");
       tl=(TableLayout)view.findViewById(R.id.contact);

        AddData();
        return view;

    }


    public void onClick(View v) {

    }





  public void search(View v){

    }

    public void AddData()
    {

        tr = new TableRow(getActivity());
        tr.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT));
        nameView = new TextView(getActivity());

        nameView.setText("Contact Name");
        //  nameView.setLayoutParams(new Layo);
        nameView.setHeight(40);
        nameView.setTextSize(18);
        nameView.setPadding(20, 15, 0, 0);

        nameView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(nameView);


        phoneView = new TextView(getActivity());
        phoneView.setText("Contact Number");
        phoneView.setPadding(20,15,0,0);
        phoneView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        phoneView.setTextSize(18);
        tr.addView(phoneView);
        tl.addView(tr, new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT, ScrollView.LayoutParams.MATCH_PARENT));

        View v = new View(c);
        v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
        v.setBackgroundColor(Color.rgb(51, 51, 51));
        tl.addView(v);
        for(int i=0;i<130;i++) {
            tr = new TableRow(getActivity());
            tr.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT));
            nameView = new TextView(getActivity());
            if(name[i]==""){
                name[i]="123";
            }
            nameView.setText(name[i]);
            nameView.setPadding(20, 15, 0, 0);
            //  nameView.setLayoutParams(new Layo);
            tr.addView(nameView);


            phoneView = new TextView(getActivity());
            phoneView.setText(phone[i]);
            phoneView.setPadding(20, 15, 0, 0);
            tr.addView(phoneView);

         tr.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 tr.setBackgroundColor(getResources().getColor(android.R.color.background_dark));
             }
         });
            tl.addView(tr, new ScrollView.LayoutParams(ScrollView.LayoutParams.WRAP_CONTENT, ScrollView.LayoutParams.MATCH_PARENT));
            // tl.addView(tr);

            View v1 = new View(c);
            v1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
            v1.setBackgroundColor(Color.rgb(51, 51, 51));
            tl.addView(v1);
        }


    }


    public void Display(){

        int c=48;

        for(int i=0 ; i <= c  ; i++){

            Log.e(name[i], "contact name");

            Log.println(type[i], "phone type", "phone type");

            Log.e(phone[i], "contact number");

        }

    }

    public void update(View v) {
        // Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        // intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        // startActivityForResult(intent, 1);
        AddData();
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        startActivityForResult(intent, 1);
       // ContentResolver cr = getContentResolver();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // super.onActivityResult(requestCode,resultCode,data);
        // PhoneContacts phoneContacts = new PhoneContacts(service);
        // phoneContacts.ReadPhoneContacts(cntx);

        // if(requestCode==1){contactInfo=data.getData();}


    }


    public void ReadPhoneContacts(Context cntx) //This Context parameter is nothing but your Activity class's Context
    {

      //  MainActivity main=new MainActivity();
      //  Cursor cursor = main.setCursor();
        Integer contactsCount = cursor.getCount(); // get how many contacts you have in your contacts list
        phone=new String[contactsCount];
        name=new String[contactsCount];
        type=new int[contactsCount];
        Contactscount=contactsCount;
        int count=0;

        if (contactsCount > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    //the below cursor will give you details for multiple contacts
                    Cursor pCursor = cntx.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);

                    name[count]=contactName;


                    //   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                    //  SharedPreferences.Editor editor = preferences.edit();
                    //  editor.putString("Name","Harneet");
                    //  editor.apply();





                    // continue till this cursor reaches to all phone numbers which are associated with a contact in the contact list
                    while (pCursor.moveToNext()) {
                        int phoneType = pCursor.getInt(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));


                        //String isStarred 		= pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.STARRED));
                        String phoneNo = pCursor.getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        //you will get all phone numbers according to it's type as below switch case.
                        //Logs.e will print the phone number along with the name in DDMS. you can use these details where ever you want.


                        phone[count]=phoneNo;



                        switch (phoneType) {
                            case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                Log.e(contactName + ": TYPE_MOBILE", " " + phoneNo);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                                Log.e(contactName + ": TYPE_HOME", " " + phoneNo);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                                Log.e(contactName + ": TYPE_WORK", " " + phoneNo);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_MOBILE:
                                Log.e(contactName + ": TYPE_WORK_MOBILE", " " + phoneNo);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_OTHER:
                                Log.e(contactName + ": TYPE_OTHER", " " + phoneNo);
                                break;
                            default:
                                break;
                        }
                    }
                    pCursor.close();
                    count++;
                }
            }

            cursor.close();
        }
    }



}
