package com.technomize.peerbucket.Activity;

import android.graphics.Typeface;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.technomize.peerbucket.R;

public class DocsAndFilesActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton madd_docs_fab;
    TextView mbs_docs_start,mbs_docs_folder,mbs_docs_upload,mbs_docs_gd,mbs_docs_dropbox,mbs_docs_box,
            mbs_docs_onedrive;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docs_and_files);

        typeface=Typeface.createFromAsset(getAssets(), "font/fawsmsolid.ttf");

        madd_docs_fab=(FloatingActionButton) findViewById(R.id.add_docs_fab);

        madd_docs_fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_docs_fab:
                View view = getLayoutInflater().inflate(R.layout.bottom_sheet_add_doc_and_files, null);

                BottomSheetDialog dialog = new BottomSheetDialog(this);
                dialog.setContentView(view);
                dialog.show();


                mbs_docs_start=(TextView) view.findViewById(R.id.bs_docs_start);
                mbs_docs_folder=(TextView) view.findViewById(R.id.bs_docs_folder);
                mbs_docs_upload=(TextView) view.findViewById(R.id.bs_docs_upload);
                mbs_docs_gd=(TextView) view.findViewById(R.id.bs_docs_gd);
                mbs_docs_dropbox=(TextView) view.findViewById(R.id.bs_docs_dropbox);
                mbs_docs_box=(TextView) view.findViewById(R.id.bs_docs_box);
                mbs_docs_onedrive=(TextView) view.findViewById(R.id.bs_docs_onedrive);

                mbs_docs_start.setTypeface(typeface);
                mbs_docs_folder.setTypeface(typeface);
                mbs_docs_upload.setTypeface(typeface);
                mbs_docs_gd.setTypeface(typeface);
                mbs_docs_dropbox.setTypeface(typeface);
                mbs_docs_box.setTypeface(typeface);
                mbs_docs_onedrive.setTypeface(typeface);

                mbs_docs_start.setText("\uF055");
                mbs_docs_folder.setText("\uF055");
                mbs_docs_upload.setText("\uF055");
                mbs_docs_gd.setText("\uF055");
                mbs_docs_dropbox.setText("\uF055");
                mbs_docs_box.setText("\uF055");
                mbs_docs_onedrive.setText("\uF055");

                break;
        }
    }
}
