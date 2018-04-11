data = load '/home/ketul/Documents/Project/FuelEconomy.csv' using PigStorage(';') as (barrels,barrelsA,charge,chargeA,city,cityA,cityB,cityBA,cityCD,cityE,cityUF,co2,co2A,co2TailpipeAGpm,co2TailpipeGpm,comb,combA,combB,combBA,combE,combinedCD,combinedUF,cylinders,displ,drive,engId,eng_dscr,feScore,fuelCost,fuelCostA,fuelType,fuelTypeA,ghgScore,ghgScoreA,highway,highwayA,highwayB,highwayBA,VClass,highwayCD,highwayE,highwayUF,hlv,hpv,id,lv,lvA,make,model,mpgData,phevBlended,pv,pvA,range,rangeCity,rangeCityA,rangeHwy,rangeHwyA,trany,UCity,UCityA,UHighway,UHighwayA,year,youSaveSpend,guzzler,trans_dscr,tCharger,sCharger,atvType,fuelTypeB,rangeA,evMotor,mfrCode,c240Dscr,charge240b,c240bDscr,createdOn,modifiedOn,startStop,phevCity,phevHwy,phevComb);
dataGroup = group data by make;
dataLoop = foreach dataGroup {
  orderData = order data by comb DESC;
  topData = limit orderData 1;
  generate FLATTEN(topData);
};
dataOutput = foreach dataLoop generate make, model, comb;
Store dataOutput into 'hdfs://localhost:9000/pig_output/bestmileagecarsforeachcompany' using PigStorage(',');
