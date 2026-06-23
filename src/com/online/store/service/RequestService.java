package com.online.store.service;



import com.online.store.model.request.Request;
import com.online.store.model.request.RequestStatus;



import java.util.ArrayList;
import java.util.List;



public class RequestService {



    private static RequestService instance;


    private List<Request> requests;







    private RequestService(){


        requests =
                new ArrayList<>();


    }







    public static RequestService getInstance(){



        if(instance==null){

            instance =
                    new RequestService();

        }


        return instance;


    }








    public void createRequest(Request request){


        requests.add(request);


    }









    public List<Request> getPendingRequests(){



        List<Request> result =
                new ArrayList<>();



        for(Request r: requests){


            if(r.getStatus()
                    ==
                    RequestStatus.PENDING){


                result.add(r);

            }


        }



        return result;


    }








    public void approveRequest(Request request){


        request.approve();


    }









    public void rejectRequest(Request request){


        request.reject();


    }





}