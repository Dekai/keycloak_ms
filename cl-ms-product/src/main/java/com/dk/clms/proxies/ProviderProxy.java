package com.dk.clms.proxies;

import com.dk.clms.config.FeignClientConfig;
import com.dk.clms.domain.Provider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="provider-service", url = "${ms.provider.url}", configuration = {FeignClientConfig.class})
public interface ProviderProxy {

    @GetMapping("/providers/{id}")
    public Provider getProvider(@PathVariable("id") String id);
}
