package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.models.Market;
import com.lambdaschool.bwafricanmarket.models.Own;
import com.lambdaschool.bwafricanmarket.models.Owner;
import com.lambdaschool.bwafricanmarket.repositories.MarketRepository;
import com.lambdaschool.bwafricanmarket.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service("marketService")
public class MarketServiceImpl implements MarketService{
    @Autowired
    UserAuditing userAuditing;
    @Autowired
    MarketRepository marketrepos;
    @Autowired
    SectionService sectionService;
    @Autowired
    OwnerRepository ownerrepos;
    @Override
    public List<Market> findAll(){
        List<Market> list = new ArrayList<>();
        marketrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    @Override
    public Market findMarketById(long id){
        return marketrepos.findById(id).orElseThrow(()-> new EntityNotFoundException("Market with id" + id + "not found"));
    }

    @Override
    public Market findMarketByLocation(Long location) {
        return null;
    }

    @Override
    public Market findMarketByLocation(String location){
        return (Market) marketrepos.findByLocation(location).orElseThrow(()-> new EntityNotFoundException("Market with location" + location + "not found"));
    }

    @Transactional
    @Override
    public void delete(long id){
        if (marketrepos.findById(id).isPresent()){
            marketrepos.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Market with id " + id + " Not Found!");
        }
    }
    @Transactional
    @Override
    public Market save(Market market)
    {
        Market newMarket = new Market();

        if (market.getMarketid() != 0){
            marketrepos.findById(market.getMarketid()).orElseThrow(() -> new EntityNotFoundException("Market id " + market.getMarketid() + " not found!"));
        }

        newMarket.setName(market.getName());
        newMarket.setLocation(market.getLocation());

        if (market.getSection() != null){
            newMarket.setSection(sectionService.findSectionById(market.getSection().getSectionid()));
        }

        newMarket.getOwns().clear();
        for (Own o : market.getOwns()){
            Owner addOwner = ownerrepos.findById(o.getOwner().getOwnerid()).orElseThrow(() -> new EntityNotFoundException("Owner Id " + o.getOwner().getOwnerid() + " Not Found!"));
            newMarket.getOwns().add(new Own(addOwner, newMarket));
        }
        return marketrepos.save(newMarket);
    }
    @Transactional
    @Override
    public Market update(Market market, long id){
        Market currentMarket = findMarketById(id);

        if (market.getName() != null){
            currentMarket.setName(market.getName());
        }

        if (market.getLocation() != null){
            currentMarket.setLocation(market.getLocation());
        }

        if (market.getSection() != null){
            currentMarket.setSection(sectionService.findSectionById(market.getSection().getSectionid()));
        }

        if (market.getOwns().size() > 0){
            currentMarket.getOwns().clear();
            for (Own o : market.getOwns()){
                Owner addOwner = ownerrepos.findById(o.getOwner().getOwnerid()).orElseThrow(() -> new EntityNotFoundException("Owner Id " + o.getOwner().getOwnerid() + " Not Found!"));
                currentMarket.getOwns().add(new Own(addOwner, currentMarket));
            }
        }

        return marketrepos.save(currentMarket);
    }
    @Transactional
    @Override
    public void deleteAll(){
        marketrepos.deleteAll();
    }

    public static class UserAuditing implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor(){
            String uname;
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null){
                uname = authentication.getName();
            }
            else {
                uname = "SYSTEM";
            }
            return Optional.of(uname);
        }
    }
}
