package com.example.farmzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class appHelp extends AppCompatActivity {


    RecyclerView AppHelpRecyclerView;
    appHelpAdapter appHelpAdapter;
    List<AppHelpItem> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    ConstraintLayout rootLayout;
    EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_help);




        //ini view
        searchInput = findViewById(R.id.search_input);
        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.root_layout);
        AppHelpRecyclerView = findViewById(R.id.apphelp_rv);
        mData = new ArrayList<>();
        //fill farm help with data
        mData.add(new AppHelpItem("What is Farmzone?", "Farmzone is an android application built by Donjur Jeriel for farmers in plateau state ","07-04-2020",R.drawable.farmerpage));
        mData.add(new AppHelpItem("How to use Farmzone", "Farmers can only register on the app if they are residents of plateau state.","07-04-2020",R.drawable.farmerpage));
        mData.add(new AppHelpItem("How to get fertilizer application", "once farmers are registered on the app, they can login with their username and password. Afterwards click on the add farm icon on the dashboard and then add your farm then afterwards add the fertilizer application. The application suggests fertilizer NPK values and the appropriate soil conditions for your crop to grow in","07-04-2020",R.drawable.farmerpage));
        mData.add(new AppHelpItem("What is a fertilizer?", "Think of fertilizers as nutritional supplements. Plants need a variety of life-sustaining nutrients—such as nitrogen and phosphorus—which they take up from the soil. Many soils contain adequate nutrients for the plants to absorb, but some soils do not, which is where fertilizers come in.           Fertilizers are plant nutrients that are added to the soil. The plants absorb these essential nutrients from the soil to improve health, growth, and productivity. Soil nutrient deficiencies reduce and modify plant growth. You can also tell which nutrients your soil is lacking by the deficiency symptoms they display, which can range from yellow leaves (lack of nitrogen) to reduced flowering (lack of phosphorus) to weak stems (lack of potassium) to blossom-end rot (lack of calcium). ","07-04-2020",R.drawable.farmerpage));
        mData.add(new AppHelpItem("How to read Fertilizer Labels", "Ever seen those confusing labels on fertilizer bags? The numbers can seem daunting at first, but once you know what they mean, they tell you exactly what you need to know about a fertilizer.  A fertilizer label on a package will have three numbers, such as 5-10-10. These numbers refer to the percentage of Nitrogen (N), Phosphorus (P), and Potassium (K), the three nutrients that plants need the most. If you add up the numbers, they are the percentage of the bag’s total weight (the rest is simply filler to make it easy to handle). There may also be other nutrients, including calcium, magnesium, iron, and manganese. ","07-04-2020",R.drawable.farmerpage));
        mData.add(new AppHelpItem("Choosing Enterprise or Premium", "Farmzone offers two packages namely; Enterprise and Premium. An Enterprise plan gives you rites to fertilizer application for 10 crops while Premium gives you access to 20 crops.","07-04-2020",R.drawable.farmerpage));
        mData.add(new AppHelpItem("When to fertilize your Farm", "If you are correcting a soil nutrient deficiency based on a soil test, it’s best to fertilize well before you plant so that you can work the fertilizer deep into the soil.\n" +
                "\n" +
                "Otherwise, fertilize in the spring before planting annual flowers and vegetables and as growth begins for perennials. Many gardeners use a general-purpose fertilizer at this time (either an evenly balanced fertilizer or one that’s slightly higher in nitrogen). Incorporate fertilize into the soil several inches deep for annuals and vegetables. For perennials, work fertilizer lightly into the soil around the plants. \n" +
                "\n" +
                "Plants need the most nutrients when they are growing most rapidly. This occurs earlier for spring plantings of lettuce and other greens. Rapid growth occurs midsummer for corn and squash. Tomatoes and potatoes also will need extra fertilizer (N) mid-season as the plants takes us nutrients.\n" +
                "\n" +
                "For a long-season crop such as corn, many gardeners apply a small amount of fertilizer as a starter at the time of seeding, and then add a larger amount in early summer, just before the period of rapid growth. When using organic fertilizers for long-season crops, a single application is usually adequate because these fertilizers release their nutrients throughout the season. \n" +
                "\n" +
                "For perennial plants, the timing depends on the plant’s growth cycle. Blueberries, for example, benefit when fertilizer is applied early in the season at bud break, while June-bearing strawberries benefit most when fertilized after harvest. \n" +
                "\n" +
                "Ornamental trees, shrubs, and perennials are often fertilized at the beginning of their growing season as dormancy breaks.  ","07-04-2020",R.drawable.farmerpage));

        mData.add(new AppHelpItem("How to apply liquid fertilizers", "All water-soluble fertilizers are applied by dissolving the product in irrigation water and then applying it to the leaves of the plant and the soil around the plant.\n" +
                "\n" +
                "Don’t apply liquid fertilizer at the exact same time that you plant. No matter how carefully you remove plants from their containers and place them in the ground, some root hairs will break. The fertilizer will reach the roots immediately and enter them at the broken points, “burning” them and causing further die-back.\n" +
                "\n" +
                "Many gardeners wait 2 to 3 weeks after planting before fertilizing with liquid solutions; by then, the newly set-out plants should have recovered from any root damage.\n" +
                "\n" +
                "It is important to water plants thoroughly with plain water before applying the liquid fertilizer to avoid burning the roots if the soil is dry. Also, take care that the fertilizer is indeed diluted based on instructions, or you could burn the leaves. If you have a watering system, you can use an injector device to run the fertilizer through the system.\n" +
                "\n" +
                "In the case of liquid sprays, it is best to apply them on dry days in either the early morning or the early evening, when the leaves will have time to absorb the material. Avoid extremely hot days when foliage is subject to burning. ","07-04-2020",R.drawable.farmerpage));
        mData.add(new AppHelpItem("How to apply granular fertilizers", "For the first fertilizer application of the season, apply granular fertilizers by broadcasting them either by hand or with a spreader over a large area. Or, side-dress the fertilizer alongside your rows or plants or seeds. All dry fertilizers should be worked or watered into the top 4 to 6 inches of soil with hoe or spade work after being applied to help the fertilizer leach down toward the plants’ root zones. If your plants are already growing, cultivate gently so that you do not damage any roots.\n" +
                "\n" +
                "During the growing season, lighter supplemental applications can be made to the top inch of soil in crop rows and perennial beds and around the drip lines of trees or shrubs. (Read the label to find out how often applications should be made.)\n" +
                "\n" +
                "In general, applying granular fertilizers just before a good rain can be beneficial, as it aids in working the fertilizer down into the soil where roots can access it. ","07-04-2020",R.drawable.farmerpage));
        //adapter ini and setup

        appHelpAdapter = new appHelpAdapter(this,mData);
        AppHelpRecyclerView.setAdapter(appHelpAdapter);
        AppHelpRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark;
                if (isDark) {
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.intro_title_color));
                }

                else{
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                }

                appHelpAdapter = new appHelpAdapter(getApplicationContext(),mData,isDark);
                AppHelpRecyclerView.setAdapter(appHelpAdapter);

            }
        });

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                appHelpAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
