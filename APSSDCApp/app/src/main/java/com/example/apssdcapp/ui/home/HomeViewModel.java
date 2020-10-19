package com.example.apssdcapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("About Organization\n\n The Govt. of AP has formed 7 different Missions to achieve double digit growth for the state and to make AP among the most developed state in the country. Among these, the Knowledge and Skills Mission has been formed to provide trained and skilled manpower to all other Missions. To bring the faster execution State Government Andhra Pradesh has established The Department of Skill Development, Entrepreneurship and Innovation (DSDEI) has been further created to coordinate and synergize skilling efforts of all departments. Under which APSSDC is formed.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}