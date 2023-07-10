package org.mrdebonis.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Margot Robbie", "Margot@gmail.com", "https://gal.img.pmdstatic.net/scale/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2FGAL.2F2019.2F09.2F23.2F93587958-1a9b-482c-960e-f0b1cf068faa.2Ejpeg/autox450/quality/65/margot-robbie-lors-de-la-88eme-ceremonie-des-oscars-a-hollywood-le-28-fevrier-2016.jpg"));
        contacts.add(new Contact("Cillian Murphy", "Cillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/1200px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg"));
        contacts.add(new Contact("Saoirse Roman", "Saoirse@gmail.com", "https://m.media-amazon.com/images/M/MV5BMjExNTM5NDE4NV5BMl5BanBnXkFtZTcwNzczMzEzOQ@@._V1_.jpg"));
        contacts.add(new Contact("Emma Watson", "Emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/7/7f/Emma_Watson_2013.jpg"));
        contacts.add(new Contact("Christian Bale", "Christian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Christian_Bale-7837.jpg"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        /*
        There are several LAyout managers:
        LinearLayoutManager: Specify oreintation: vertical or horizontal
        GridLAyoutMAnager : Specify columns
         */
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));

    }
}