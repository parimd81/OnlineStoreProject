package com.online.store.controller;


import com.online.store.enums.RequestStatus;
import com.online.store.model.requests.Request;
import com.online.store.model.users.User;


import java.util.ArrayList;
import java.util.List;



public class RequestController {


    private List<Request> requests;



    public RequestController() {

        requests = new ArrayList<>();

    }



    // ایجاد درخواست جدید

    public Request createRequest(User user,
                                 String description) {


        Request request =
                new Request(
                        requests.size() + 1,
                        user,
                        description
                );


        requests.add(request);


        return request;
    }





    // گرفتن تمام درخواست‌ها

    public List<Request> getAllRequests() {


        return requests;

    }





    // تایید درخواست

    public void approveRequest(int requestId) {


        for(Request request : requests) {


            if(request.getId() == requestId) {


                request.setStatus(
                        RequestStatus.APPROVED
                );


                return;
            }

        }

    }





    // رد درخواست

    public void rejectRequest(int requestId) {


        for(Request request : requests) {


            if(request.getId() == requestId) {


                request.setStatus(
                        RequestStatus.REJECTED
                );


                return;
            }

        }

    }





    // درخواست‌های یک کاربر خاص

    public List<Request> getUserRequests(User user) {


        List<Request> result =
                new ArrayList<>();


        for(Request request : requests) {


            if(request.getSender()
                    .equals(user)) {


                result.add(request);

            }

        }


        return result;

    }

}