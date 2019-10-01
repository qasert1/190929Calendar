package com.example.a190929calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private Calendar cal;
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private int getMonthLastDay(int year, int month) {
        switch (month) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return (31);

            case 3:
            case 5:
            case 8:
            case 10:
                return (30);

            default:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400) == 0) {
                    return (29);
                } else {
                    return (28);
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long now = System.currentTimeMillis();
        Date date = new Date(now);

        final DateFormat curYear = new SimpleDateFormat("yyyy", Locale.KOREA);
        final DateFormat curMonth = new SimpleDateFormat("MM", Locale.KOREA);

        Date nowYear = new Date();
        String tempDate1 = curYear.format(nowYear);
        int intcurYear = Integer.parseInt(tempDate1);

        Date nowMonth = new Date();
        String tempDate2 = curMonth.format(nowMonth);
        int intcurMonth = Integer.parseInt(tempDate2);

        Log.d("TAG", "intcurYear :" + intcurYear);
        Log.d("TAG", "intcurYear :" + intcurMonth);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 7);
        recyclerView.setLayoutManager(layoutManager);

        cal = Calendar.getInstance();

        cal.set(Calendar.DATE, 1);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        ArrayList<item> arrayList = new ArrayList<>();

        for (int i = 0; i < firstDayOfWeek - 1; i++) {
            arrayList.add(new item(""));
        }


        for (int i = 1; i < cal.getActualMaximum(Calendar.DATE) + 1; i++) {
            arrayList.add(new item("" + i));
        }

        Log.d("TAG", "getMonthLastDay : " + getMonthLastDay(intcurYear, intcurMonth));

        recycleAdpater recycleAdpater = new recycleAdpater(arrayList);
        recyclerView.setAdapter(recycleAdpater);

    }
}
