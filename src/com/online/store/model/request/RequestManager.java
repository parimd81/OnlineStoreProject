package com.online.store.model.request;


import java.util.ArrayList;
import java.util.List;


public class RequestManager {


    private List<Request> requests =
            new ArrayList<>();



    public void addRequest(Request request){

        requests.add(request);

    }




    public List<Request> getPendingRequests(){

        List<Request> result =
                new ArrayList<>();


        for(Request r : requests){

            if(r.getStatus()
                    == RequestStatus.PENDING){

                result.add(r);

            }

        }


        return result;

    }




    public Request findById(int id){


        for(Request r : requests){

            if(r.getId() == id){

                return r;

            }

        }


        return null;

    }




    public void approveRequest(int id){


        Request request =
                findById(id);


        if(request != null){

            request.approve();

        }

    }





    public void rejectRequest(int id){


        Request request =
                findById(id);


        if(request != null){

            request.reject();

        }

    }


}