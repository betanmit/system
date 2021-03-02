package com.example.fourthprogram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nm,lc,pro,fn,uploc,upprof;
    TextView fl,fp;
    View fetchbtn,updatebtn,delbtn;
    DbController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm=findViewById(R.id.name);
        lc=findViewById(R.id.location);
        pro=findViewById(R.id.Profession);
        fn=findViewById(R.id.fetchname);
        fl=findViewById(R.id.fetchloc);
        fp=findViewById(R.id.fetchpro);
        fetchbtn=findViewById(R.id.fetchbtn);
        updatebtn=findViewById(R.id.updatebtn);
        delbtn=findViewById(R.id.delbtn);
        uploc=findViewById(R.id.updatelocation);
        upprof=findViewById(R.id.updateprofession);
        dbController=new DbController(this);
    }

    public void insert(View v){
        String name=nm.getText().toString();
        String loc=lc.getText().toString();
        String prof=pro.getText().toString();
        if(dbController.insetdb(name,loc,prof)){
            Toast.makeText(this, "Insertion Success", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Unable to insert", Toast.LENGTH_SHORT).show();
        }
    }

    public void getd(View v){
        String name=fn.getText().toString();
        String fd[]=dbController.fetchdb(name);
        if(fd.length==0){
            Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show();
        }else {
            fl.setText(fd[0]);
            fp.setText(fd[1]);
            fl.setVisibility(View.VISIBLE);
            fp.setVisibility(View.VISIBLE);
            uploc.setVisibility(View.VISIBLE);
            upprof.setVisibility(View.VISIBLE);
            fetchbtn.setVisibility(View.GONE);
            updatebtn.setVisibility(View.VISIBLE);
            delbtn.setVisibility(View.VISIBLE);
        }
    }

    public void update(View v){
        String id=fn.getText().toString();
        String loc=uploc.getText().toString();
        String prof=upprof.getText().toString();
        Boolean flag=dbController.updatedb(id,loc,prof);
        if(flag==true){
            Toast.makeText(this, "Update Successful", Toast.LENGTH_SHORT).show();
            fetchbtn.setVisibility(View.VISIBLE);
            updatebtn.setVisibility(View.GONE);
            delbtn.setVisibility(View.GONE);
            uploc.setVisibility(View.GONE);
            uploc.getText().clear();
            upprof.setVisibility(View.GONE);
            upprof.getText().clear();
            fl.setVisibility(View.GONE);
            fp.setVisibility(View.GONE);
        }

    }
    public void del(View v){
        String id =fn.getText().toString();
        if(dbController.deldb(id)){
            fetchbtn.setVisibility(View.VISIBLE);
            updatebtn.setVisibility(View.GONE);
            delbtn.setVisibility(View.GONE);
            uploc.setVisibility(View.GONE);
            upprof.setVisibility(View.GONE);
            fl.setVisibility(View.GONE);
            fp.setVisibility(View.GONE);
            Toast.makeText(this, "Delete Successful", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Unable to delete", Toast.LENGTH_SHORT).show();

    }
}