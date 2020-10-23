package com.example.roomdbdemo;

        import android.app.Application;
        import android.os.AsyncTask;

        import androidx.lifecycle.LiveData;

        import java.util.List;

public class StudentRepo {
    StudentDataBase studentDataBase;
    LiveData<List<StudentEntity>> listLiveData;

    public StudentRepo(Application application) {
        studentDataBase = StudentDataBase.getInstance(application);
        listLiveData = studentDataBase.studentDAO().liveData();
    }
    public void insert(StudentEntity entity){
        new AsynckTaskForInsert().execute(entity);
    }
    public void update(StudentEntity entity){
        new AsynckTaskFoUpdate().execute(entity);
    }
    public void delete(StudentEntity entity){
        new AsynckTaskForDelete().execute(entity);
    }

    public class AsynckTaskForInsert extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDataBase.studentDAO().insert(studentEntities[0]);
            return null;
        }
    }
    public class AsynckTaskFoUpdate extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDataBase.studentDAO().update(studentEntities[0]);
            return null;
        }
    }
    public class AsynckTaskForDelete extends AsyncTask<StudentEntity,Void,Void>{

        @Override
        protected Void doInBackground(StudentEntity... studentEntities) {
            studentDataBase.studentDAO().delete(studentEntities[0]);
            return null;
        }
    }

    public LiveData<List<StudentEntity>> listLiveData(){
        return listLiveData;
    }
}
