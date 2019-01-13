package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.example.sridharjajoo.magicsnatch.R;
import com.example.sridharjajoo.magicsnatch.data.Upload;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MagicSnatchDashboardActivity extends AppCompatActivity implements HasSupportFragmentInjector{

    @BindView(R.id.furniture_rv)
    RecyclerView furnitureRv;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private MagicSnatchFurnitureAdapter magicSnatchFurnitureAdapter;
    private ArrayList<Drawable> furnitureItem;
    private final int RESULT_LOAD_IMAGE = 1;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_snatch_dashboard);
        ButterKnife.bind(this);
        storage = FirebaseStorage.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        storageReference = storage.getReference();
        setUpRv();
    }

    private String getMimeType(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void setUpRv() {
        furnitureItem = new ArrayList<>();
        loadImages();
        magicSnatchFurnitureAdapter = new MagicSnatchFurnitureAdapter(furnitureItem);
        furnitureRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        furnitureRv.setAdapter(magicSnatchFurnitureAdapter);
    }

    private void loadImages() {
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_0));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_1));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_2));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_3));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_4));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_5));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_6));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_7));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_8));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_9));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_10));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_11));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_12));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_13));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_14));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_15));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_16));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_17));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_18));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_19));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_20));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_21));
    }

    @OnClick(R.id.fab)
    public void returnImages() {
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Log.i("MagicSnatch", "onActivityResult: " + data.getData());
            uploadImageFirebase(data.getData());
        }
    }

    private void uploadImageFirebase(Uri path) {
        if (path != null) {
            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(path)
                    .addOnSuccessListener(taskSnapshot -> {
                        Toast.makeText(MagicSnatchDashboardActivity.this, "Uploaded!", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> Toast.makeText(MagicSnatchDashboardActivity.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show())
                    .addOnCompleteListener(task -> {
                        String id = databaseReference.push().getKey();
                        if (task.isSuccessful()) {
                            UploadTask.TaskSnapshot downloadUri = task.getResult();
                            Upload upload = new Upload(path.toString(), downloadUri.toString());
                            Log.i("MagicSnatch", "uploadImageFirebase: " + upload);
                            databaseReference.child(id).setValue(upload);
                        }
                    })
                    .addOnProgressListener(taskSnapshot -> {
                        Log.i("MagicSnatch", "uploadImageFirebase: " + 100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                .getTotalByteCount());
                        double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                .getTotalByteCount());
                    });
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
