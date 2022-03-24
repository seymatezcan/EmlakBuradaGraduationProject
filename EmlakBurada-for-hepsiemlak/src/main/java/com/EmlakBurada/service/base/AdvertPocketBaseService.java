package com.EmlakBurada.service.base;

import com.EmlakBurada.dto.request.AdvertPocketRequest;
import com.EmlakBurada.dto.request.AdvertRequest;
import com.EmlakBurada.model.Advert;
import com.EmlakBurada.model.AdvertPocket;
import com.EmlakBurada.model.Enrollee;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AdvertPocketBaseService {

    public AdvertPocket convertToAdvertPocketEntity(AdvertPocketRequest advertPocketRequest, Enrollee enrollee){
        AdvertPocket advertPocket=new AdvertPocket();
        advertPocket.setEnrolleeId(advertPocketRequest.getEnrolleeId());
        advertPocketRequest.setCountOfAdvertTenancy(advertPocketRequest.getCountOfAdvertTenancy());
        return advertPocket;
    }

}
