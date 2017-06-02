package exampel.com.myapplication.Retrofit.utility;

import java.io.IOException;
import java.lang.annotation.Annotation;

import exampel.com.myapplication.Retrofit.models.ErrorModel;
import exampel.com.myapplication.Retrofit.network.Provider;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Ali on 01/06/2017.
 */

public class ErrorUtils {

    public static ErrorModel parseError(Response<?> response){
        Provider provider=new Provider();
        Converter<ResponseBody , ErrorModel> converter
                =provider.getRetrofitClient().responseBodyConverter(ErrorModel.class,new Annotation[0]);
        ErrorModel errorModel;
        try{
            errorModel=converter.convert(response.errorBody());}
        catch (IOException e){
            return new ErrorModel();
        }
        return errorModel;
    }
}
