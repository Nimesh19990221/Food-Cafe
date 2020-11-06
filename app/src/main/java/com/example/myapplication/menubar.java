package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class menubar extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {
    SliderLayout sliderLayout ;

    HashMap<String, String> HashMapForURL ;

    HashMap<String, Integer> HashMapForLocalRes ;

    TextView burger;
    TextView burger1;
    ImageView  burgerimg;
    TextView coffee;
    TextView coffee1;
    ImageView  coffeeimg;
    TextView juice;
    TextView juice1;
    ImageView  juiceimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubar);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.homy) {
                    Intent intent = new Intent(menubar.this,MainActivity.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.dashboard) {
                    Intent intent = new Intent(menubar.this,menubar.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.setting) {
                    Intent intent = new Intent(menubar.this,preference.class);

                    startActivity(intent);

                    return true;
                }
                return true;
            }
        });
        sliderLayout = (SliderLayout) findViewById(R.id.slider);

        //Call this method if you want to add images from URL .
        AddImagesUrlOnline();

        //Call this method to add images from local drawable folder .
        //AddImageUrlFormLocalRes();

        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for (String name : HashMapForURL.keySet()) {

            TextSliderView textSliderView = new TextSliderView(menubar.this);

            textSliderView
                    .description(name)
                    .image(HashMapForURL.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderLayout.setCustomAnimation(new DescriptionAnimation());

        sliderLayout.setDuration(3000);

        sliderLayout.addOnPageChangeListener(menubar.this);
        burger=(TextView)findViewById(R.id.burger);
        burger1=(TextView)findViewById(R.id.burger1);
        burgerimg=(ImageView)findViewById(R.id.burgerimg);
        coffee=(TextView)findViewById(R.id.hod);
        coffee1=(TextView)findViewById(R.id.hod1);
        coffeeimg=(ImageView)findViewById(R.id.hodmg);
        juice=(TextView)findViewById(R.id.juice);
        juice1=(TextView)findViewById(R.id.juice1);
        juiceimg=(ImageView)findViewById(R.id.juicemg);
        burgerimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                burgerimg();
            }
        });
        burger1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                burger1();
            }
        });
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                burger();
            }
        });
        coffeeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeimg();
            }
        });
        coffee1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee1();
            }
        });
        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee();
            }
        });
        juiceimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juiceimg();
            }
        });
        juice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juice1();
            }
        });
        juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juice();
            }
        });
    }


    public void burger(){
        Intent intent=new Intent(this, burger.class);
        startActivity(intent);

    }
    public void burger1(){
        Intent intent1=new Intent(this, burger.class);
        startActivity(intent1);

    }
    public void burgerimg(){
        Intent intent2=new Intent(this, burger.class);
        startActivity(intent2);

    }
    public void coffee(){
        Intent intent3=new Intent(this,hotdrinks .class);
        startActivity(intent3);

    }
    public void coffee1(){
        Intent intent4=new Intent(this, hotdrinks.class);
        startActivity(intent4);

    }
    public void coffeeimg(){
        Intent intent5=new Intent(this, hotdrinks.class);
        startActivity(intent5);

    }
    public void juice(){
        Intent intent6=new Intent(this, juice.class);
        startActivity(intent6);

    }
    public void juice1(){
        Intent intent7=new Intent(this, juice.class);
        startActivity(intent7);

    }
    public void juiceimg(){
        Intent intent8=new Intent(this, juice.class);
        startActivity(intent8);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.set1) {
            Intent intent = new Intent(menubar.this,preference.class);

            startActivity(intent);

            return true;
        }
        if (id == R.id.privacy1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.food-cafe.com/privacy-policy/"));

            startActivity(intent);

            return true;
        }
        if (id == R.id.location) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(" https://www.google.com/maps/place/Food+cafe/@6.9845798,80.4921303,17z/data=!3m1!4b1!4m5!3m4!1s0x3ae39f2af82c65a3:0xd413fc7421272939!8m2!3d6.9845798!4d80.494319"));
            startActivity(intent);

            return true;
        }
        if (id == R.id.b1) {
            Intent intent = new Intent(menubar.this, burger.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.j1) {
            Intent intent = new Intent(menubar.this, juice.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.hot1) {
            Intent intent = new Intent(menubar.this,hotdrinks.class);

            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private void AddImagesUrlOnline() {
        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put("Burgers", "https://www.readersdigest.ca/wp-content/uploads/2015/11/gourmet-burger.jpg");
        HashMapForURL.put("Pizza", "https://hdwallpaper.move.pk/wp-content/uploads/2015/10/pizza-image.jpg");
        HashMapForURL.put("Juices", "https://cdn2.howtostartanllc.com/images/business-ideas/purchasing-guide/juice-bar.jpg");
        HashMapForURL.put("Coctail", "https://d2td6mzj4f4e1e.cloudfront.net/wp-content/uploads/sites/9/2019/04/soft-drinks.jpg");
        HashMapForURL.put("Hot Drinks", "http://www.coachhouseinn.co.uk/wp-content/uploads/2016/09/billionphotos-1675816-830x553.png");
    }

    public void AddImageUrlFormLocalRes(){

        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("CupCake", R.drawable.bur1);
        HashMapForLocalRes.put("Donut", R.drawable.bur2);
        HashMapForLocalRes.put("Eclair", R.drawable.bur3);
        HashMapForLocalRes.put("Froyo", R.drawable.bur4);
        HashMapForLocalRes.put("GingerBread", R.drawable.food);

    }
}
