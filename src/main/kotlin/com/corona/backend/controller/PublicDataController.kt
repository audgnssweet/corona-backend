package com.corona.backend.controller

import com.corona.backend.domain.infection.res.InfectionRegionRes
import com.corona.backend.domain.infection.res.InfectionRes
import com.corona.backend.domain.inoculation.res.InoculationRegionRes
import com.corona.backend.domain.inoculation.res.InoculationRes
import com.corona.backend.service.PublicDataService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/data")
class PublicDataController(
    private val publicDataService: PublicDataService,
) {

    @ApiOperation("감염(전국)")
    @GetMapping("/infection")
    fun getInfection(): InfectionRes {
        return InfectionRes.from(publicDataService.getInfection())
    }

    @ApiOperation("감염(시/도)")
    @GetMapping("/infection-region")
    fun getInfectionRegion(): InfectionRegionRes {
        return InfectionRegionRes.from(publicDataService.getInfectionRegion())
    }

    @ApiOperation("접종(전국)")
    @GetMapping("/inoculation")
    fun getInoculation(): InoculationRes {
        return InoculationRes.from(publicDataService.getInoculation())
    }

    @ApiOperation("접종(시/도)")
    @GetMapping("/inoculation-region")
    fun getInoculationRegion(): InoculationRegionRes {
        return InoculationRegionRes.from(publicDataService.getInoculationRegion())
    }
}
