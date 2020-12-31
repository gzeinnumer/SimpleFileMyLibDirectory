package com.gzeinnumer.simplefilemylibdirectory;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.gzndirectory.helper.FGDir;
import com.gzeinnumer.gzndirectory.helper.FGFile;
import com.gzeinnumer.simplefilemylibdirectory.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //todo 13 initOnClick
        initOnClick();

    }

    private void initOnClick() {
        //todo 14
        binding.btnCreateFile.setOnClickListener(v -> {
            String[] data = new String[]{"Hallo GZeinNumer Again", "File Creating","File Created"};

            String fileName = "/MyFile.txt";
            String saveTo = "/Folder_File";
            if(FGFile.initFile(fileName, saveTo,data)){
                Toast.makeText(this, "MyFile.txt berhasil dibuat", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "MyFile.txt gagal dibuat", Toast.LENGTH_SHORT).show();
            }
        });

        //todo 15
        binding.btnIsFileExists.setOnClickListener(v -> {
            //check is MyFile.txt exists
            boolean isExists = FGFile.isFileExists("/Folder_File/MyFile.txt");
            Toast.makeText(MainActivity.this, "MyFile.txt isExists status : "+isExists, Toast.LENGTH_SHORT).show();
        });

        //todo 16
        binding.btnReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = FGFile.readFile("/Folder_File/MyFile.txt");
                Toast.makeText(MainActivity.this, list.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //todo 17
        binding.btnAppentFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   /storage/emulated/0/MyLibsTesting/MyFile.txt
                String path = "/Folder_File/MyFile.txt";
                if (FGDir.isFileExists(path)){
                    String[] messages = {"New Line 1","New Line 2"};

                    //function untuk menambah text ke file yang sudah dibuat sebelumnya
                    if(FGFile.appentText(path, messages)){
                        Toast.makeText(getApplicationContext(), "Line baru ditambah ke MyFile.txt", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Ada error ketika add pesan", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "MyFile.txt tidak ditemukan", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //todo 18
        binding.btnDeleteFile.setOnClickListener(v -> {
            //delete MyFile.txt
            boolean isDeleted = FGFile.deleteDir("/Folder_File/MyFile.txt");
            Toast.makeText(MainActivity.this, "MyFile.txt dihapus status: "+isDeleted, Toast.LENGTH_SHORT).show();
        });
    }
}