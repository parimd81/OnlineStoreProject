package com.online.store.service;



import com.online.store.model.request.Request;

import java.util.ArrayList;
import java.util.List;



public class RequestService {



    private List<Request> requests =
            new ArrayList<>();






    public void createRequest(Request request){

        requests.add(request);

    }






    public List<Request> getRequests(){

        return requests;

    }






    public void acceptRequest(int id){


        for(Request r : requests){


            if(r.getId()==id){

                r.accept();

            }

        }

    }







    public void rejectRequest(int id){


        for(Request r : requests){


            if(r.getId()==id){

                r.reject();

            }

        }

    }


}