package com.sf;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.sf.entity.SfLicensePlateConfigParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LicensePlates {
    public static void main(String[] args) {
        SfLicensePlateConfigParam param = new SfLicensePlateConfigParam();

        // 用换行符分割字符串
        String[] platesArray = input.split("\n");

        // 创建一个 List 来存储车牌
        Set<String> licensePlates = new HashSet<>();

        // 遍历处理后的数组，并将其存入 List 中
        for (String plate : platesArray) {
            // 去除字符串两端的空白字符
            String processedPlate = plate.trim();
            // 如果字符串不为空，则加入到列表中
            if (!processedPlate.isEmpty()) {
                licensePlates.add(processedPlate.trim());
            }
        }
        param.setIsDeleted(0);
        param.setLicensePlates(licensePlates);

        System.out.println("\""+StrUtil.join("\",\"",licensePlates)+ "\"");
        // 打印存储的车牌
   //     System.out.println(JSON.toJSONString(param));
//        for (String plate : licensePlates) {
//            System.out.println(plate);
//        }
    }


    // 输入的车牌字符串
    public static final  String input ="赣CDA13挂\n" +
            "赣CAS01挂\n" +
            "赣CAN90挂\n" +
            "赣CAX57挂\n" +
            "赣CBZ35挂\n" +
            "赣CAZ56挂\n" +
            "赣CBE40挂\n" +
            "赣CAG00挂\n" +
            "赣CEU57挂\n" +
            "赣CET48挂\n" +
            "赣CER25挂\n" +
            "赣CEJ35挂\n" +
            "赣CEB48挂\n" +
            "赣CDE71挂\n" +
            "赣CDE62挂\n" +
            "赣CDL79挂\n" +
            "赣CDB26挂\n" +
            "赣CDF55挂\n" +
            "赣CDE19挂\n" +
            "赣CDC51挂\n" +
            "赣CDC08挂\n" +
            "赣CDB32挂\n" +
            "赣CDA31挂\n" +
            "赣CAN60挂\n" +
            "赣CBC41挂\n" +
            "赣CAX50挂\n" +
            "赣CER62挂\n" +
            "沪DH201挂\n" +
            "沪DU735挂\n" +
            "沪DB157挂\n" +
            "沪DS110挂\n" +
            "沪DJ772挂\n" +
            "沪DU716挂\n" +
            "沪DH325挂\n" +
            "沪DS201挂\n" +
            "沪K7765挂\n" +
            "沪K5638挂\n" +
            "沪K6012挂\n" +
            "沪J6132挂\n" +
            "沪K3731挂\n" +
            "沪K0832挂\n" +
            "沪J7713挂\n" +
            "沪J7933挂\n" +
            "赣CAZ41挂\n" +
            "赣CBZ89挂\n" +
            "赣CAR52挂\n" +
            "赣CBT42挂\n" +
            "赣CAG42挂\n" +
            "赣CAP47挂\n" +
            "赣CEN41挂\n" +
            "赣CDL51挂\n" +
            "赣CDF97挂\n" +
            "赣CDE50挂\n" +
            "赣CDC59挂\n" +
            "赣CDA76挂\n" +
            "赣CAP63挂\n" +
            "赣CBZ91挂\n" +
            "赣CBQ42挂\n" +
            "赣CBZ70挂\n" +
            "赣CAD26挂\n" +
            "赣CDA42挂\n" +
            "赣CDF80挂\n" +
            "赣CAP58挂\n" +
            "赣CBT41挂\n" +
            "赣CBE41挂\n" +
            "赣CBZ41挂\n" +
            "赣CBC27挂\n" +
            "赣CDB49挂\n" +
            "赣CBZ59挂\n" +
            "赣CBP41挂\n" +
            "赣CAV17挂\n" +
            "赣CAN41挂\n" +
            "赣C44H5挂\n" +
            "赣CER32挂\n" +
            "赣CEZ07挂\n" +
            "赣CEZ17挂\n" +
            "赣CEY10挂\n" +
            "赣CEN52挂\n" +
            "赣CEN60挂\n" +
            "赣CEM91挂\n" +
            "赣CEL71挂\n" +
            "赣CEJ90挂\n" +
            "赣CEG46挂\n" +
            "赣CEJ10挂\n" +
            "赣CEB80挂\n" +
            "赣CCE47挂\n" +
            "赣CDD89挂\n" +
            "赣CDG79挂\n" +
            "赣CDG13挂\n" +
            "赣CDF06挂\n" +
            "赣CDD46挂\n" +
            "赣CBU60挂\n" +
            "赣CAW42挂\n" +
            "赣CAH60挂\n" +
            "赣CAC13挂\n" +
            "赣CAE49挂\n" +
            "赣C64V3挂\n" +
            "赣CBM43挂\n" +
            "沪K1679挂\n" +
            "沪K2958挂\n" +
            "沪J8359挂\n" +
            "沪K1110挂\n" +
            "黑AA660挂\n" +
            "赣CAY67挂\n" +
            "黑AA137挂\n" +
            "黑AB053挂\n" +
            "黑AB202挂\n" +
            "黑AB258挂\n" +
            "黑AB515挂\n" +
            "黑AA150挂\n" +
            "黑AA045挂\n" +
            "黑AA210挂\n" +
            "黑AB388挂\n" +
            "黑AA334挂\n" +
            "黑AA217挂\n" +
            "黑AB238挂\n" +
            "黑AB279挂\n" +
            "黑AB322挂\n" +
            "黑AA702挂\n" +
            "赣CBR61挂\n" +
            "黑AA139挂\n" +
            "黑AA133挂\n" +
            "黑AA785挂\n" +
            "黑AA269挂\n" +
            "黑AB309挂\n" +
            "黑AA831挂\n" +
            "黑AA126挂\n" +
            "黑AA226挂\n" +
            "黑AA691挂\n" +
            "黑AB365挂\n" +
            "黑AB239挂\n" +
            "黑AB217挂\n" +
            "黑A9973挂\n" +
            "黑AA227挂\n" +
            "黑AA216挂\n" +
            "黑AA725挂\n" +
            "黑AB218挂\n" +
            "黑AA136挂\n" +
            "赣CBU26挂\n" +
            "赣CDM03挂\n" +
            "黑AA239挂\n" +
            "黑AB338挂\n" +
            "黑AB281挂\n" +
            "黑AA156挂\n" +
            "黑AA151挂\n" +
            "黑AA145挂\n" +
            "黑AA143挂\n" +
            "黑AA135挂\n" +
            "黑AA131挂\n" +
            "黑AA130挂\n" +
            "黑AA129挂\n" +
            "黑AA128挂\n" +
            "黑AA121挂\n" +
            "黑AA106挂\n" +
            "黑AA083挂\n" +
            "黑AA052挂\n" +
            "黑AA220挂\n" +
            "黑AA218挂\n" +
            "黑AA225挂\n" +
            "黑ACC28挂\n" +
            "黑AA195挂\n" +
            "黑AA212挂\n" +
            "黑AA221挂\n" +
            "黑AA231挂\n" +
            "黑AA232挂\n" +
            "黑AA230挂\n" +
            "黑AA193挂\n" +
            "黑AA205挂\n" +
            "黑AA229挂\n" +
            "黑AA213挂\n" +
            "黑A9971挂\n" +
            "黑A9979挂\n" +
            "黑AA929挂\n" +
            "黑AA895挂\n" +
            "黑AA903挂\n" +
            "黑AA690挂\n" +
            "黑AA957挂\n" +
            "黑AA271挂\n" +
            "黑AB216挂\n" +
            "黑AA792挂\n" +
            "黑AB299挂\n" +
            "黑AB308挂\n" +
            "黑AB337挂\n" +
            "黑AA823挂\n" +
            "黑AB305挂\n" +
            "黑AA931挂\n" +
            "黑AB256挂\n" +
            "黑AB296挂\n" +
            "黑AB197挂\n" +
            "黑AB517挂\n" +
            "黑AB273挂\n" +
            "黑AB529挂\n" +
            "黑AB072挂\n" +
            "黑AB285挂\n" +
            "赣CBN31挂\n" +
            "赣CCJ71挂\n" +
            "赣CCC60挂\n" +
            "赣CCD72挂\n" +
            "赣CCH02挂\n" +
            "赣CBR92挂\n" +
            "赣CBT16挂\n" +
            "赣CBT70挂\n" +
            "赣CBT55挂\n" +
            "赣CBR50挂\n" +
            "赣CBT38挂\n" +
            "赣CBT50挂\n" +
            "赣CBT71挂\n" +
            "赣CBR16挂\n" +
            "赣CBT08挂\n" +
            "赣CBT35挂\n" +
            "赣CBT48挂\n" +
            "赣CBT52挂\n" +
            "赣CBR38挂\n" +
            "赣CBT63挂\n" +
            "赣CBR20挂\n" +
            "赣CAT93挂\n" +
            "赣CAU30挂\n" +
            "赣CAZ70挂\n" +
            "赣CAZ10挂\n" +
            "赣CBQ93挂\n" +
            "赣CBX08挂\n" +
            "赣CBV82挂\n" +
            "赣CBN01挂\n" +
            "赣CBP95挂\n" +
            "赣CBZ63挂\n" +
            "赣CBS08挂\n" +
            "赣CBW03挂\n" +
            "赣CBQ53挂\n" +
            "赣CBU87挂\n" +
            "赣CBQ25挂\n" +
            "赣CBV80挂\n" +
            "赣CBU95挂\n" +
            "赣CBB60挂\n" +
            "赣CBW68挂\n" +
            "赣CBX02挂\n" +
            "赣CBR37挂\n" +
            "赣CBT61挂\n" +
            "赣CBR63挂\n" +
            "赣CBT05挂\n" +
            "赣CBT27挂\n" +
            "赣CBR62挂\n" +
            "赣CBR93挂\n" +
            "赣CBR52挂\n" +
            "赣CBR73挂\n" +
            "赣CBR35挂\n" +
            "赣CBR22挂\n" +
            "赣CBT31挂\n" +
            "赣CBR00挂\n" +
            "赣CBR05挂\n" +
            "赣CAY17挂\n" +
            "赣CAB69挂\n" +
            "赣CAU19挂\n" +
            "赣CAZ50挂\n" +
            "赣CAU22挂\n" +
            "赣CAU60挂\n" +
            "赣CAU85挂\n" +
            "赣CAN70挂\n" +
            "赣CAR80挂\n" +
            "赣CAY09挂\n" +
            "赣CAN71挂\n" +
            "赣CAP12挂\n" +
            "赣CAP52挂\n" +
            "赣CAP78挂\n" +
            "赣CAZ33挂\n" +
            "赣CAN53挂\n" +
            "赣CAR28挂\n" +
            "赣CAX76挂\n" +
            "赣CAN19挂\n" +
            "赣CAY01挂\n" +
            "赣CAR87挂\n" +
            "赣CAK96挂\n" +
            "赣CAE13挂\n" +
            "赣CAC98挂\n" +
            "赣CBR11挂\n" +
            "赣CDK02挂\n" +
            "赣CDR08挂\n" +
            "赣CDJ02挂\n" +
            "赣CDK10挂\n" +
            "赣CDW60挂\n" +
            "赣CDJ12挂\n" +
            "赣CDF70挂\n" +
            "赣CDU51挂\n" +
            "赣CDB43挂\n" +
            "赣CDE75挂\n" +
            "赣CDH62挂\n" +
            "赣CDC43挂\n" +
            "赣CDC72挂\n" +
            "赣CDG01挂\n" +
            "赣CDN93挂\n" +
            "赣CDM41挂\n" +
            "赣CDC09挂\n" +
            "赣CDF45挂\n" +
            "赣CDF91挂\n" +
            "赣CDZ77挂\n" +
            "赣CDW67挂\n" +
            "赣CDF01挂\n" +
            "赣CDF57挂\n" +
            "赣CDZ91挂\n" +
            "赣CDY17挂\n" +
            "赣CDH49挂\n" +
            "赣CDD20挂\n" +
            "赣CDV46挂\n" +
            "赣CDY81挂\n" +
            "赣CDX92挂\n" +
            "赣CDC49挂\n" +
            "赣CDK50挂\n" +
            "赣CDF39挂\n" +
            "赣CDG43挂\n" +
            "赣CDL49挂\n" +
            "赣CDD43挂\n" +
            "赣CDE91挂\n" +
            "赣CCW15挂\n" +
            "赣CCW39挂\n" +
            "赣CCW45挂\n" +
            "赣CCW76挂\n" +
            "赣CCW26挂\n" +
            "赣CCW61挂\n" +
            "赣CCW32挂\n" +
            "赣CBC46挂\n" +
            "赣CBT57挂\n" +
            "赣CBA30挂\n" +
            "赣CBX48挂\n" +
            "赣CAP83挂\n" +
            "赣CAP36挂\n" +
            "赣CAY37挂\n" +
            "赣CAN49挂\n" +
            "赣CAY71挂\n" +
            "黑AA252挂\n" +
            "黑AB307挂\n" +
            "黑AB252挂\n" +
            "黑AA971挂\n" +
            "黑AA762挂\n" +
            "黑AB328挂\n" +
            "赣F6E72挂\n" +
            "赣F5E33挂\n" +
            "赣F91E1挂\n" +
            "赣F666C挂\n" +
            "赣FE227挂\n" +
            "赣FE756挂\n" +
            "粤BT137挂\n" +
            "粤BS805挂\n" +
            "赣F73E5挂\n" +
            "赣F7E11挂\n" +
            "赣F13E7挂\n" +
            "沪BC592挂\n" +
            "沪BS751挂\n" +
            "粤BE438挂\n" +
            "沪L0531挂\n" +
            "沪AD668挂\n" +
            "沪BW713挂\n" +
            "沪BU715挂\n" +
            "粤AHF98挂\n" +
            "粤ACJ90挂\n" +
            "闽HE561挂\n" +
            "粤BSC07挂\n" +
            "豫QAA57挂\n" +
            "浙B5W968\n" +
            "浙B5X861\n" +
            "浙B3Q693\n" +
            "沪DL709挂\n" +
            "沪BG773挂\n" +
            "沪L2898挂\n" +
            "赣C8533X\n" +
            "赣CBX19挂\n" +
            "赣C6500Z\n" +
            "赣CBP22挂\n" +
            "赣C7762Z\n" +
            "赣CBK11挂\n" +
            "赣CBU259\n" +
            "赣CBP20挂\n" +
            "赣CBM573\n" +
            "冀A23MP挂\n" +
            "赣CBM493\n" +
            "冀AMU44挂\n" +
            "赣CBP497\n" +
            "冀A35PV挂\n" +
            "赣CBG833\n" +
            "冀A13WK挂\n" +
            "赣CBR701\n" +
            "赣CBD38挂\n" +
            "赣CBQ492\n" +
            "赣CBN79挂\n" +
            "赣CBU377\n" +
            "赣CBD40挂\n" +
            "赣CBR466\n" +
            "赣CBC23挂\n" +
            "赣C5560Z\n" +
            "冀APZ07挂\n" +
            "冀AZE06挂\n" +
            "赣CBU621\n" +
            "冀A69XQ挂\n" +
            "赣CBQ32挂\n" +
            "冀A09KG挂\n" +
            "冀A84007\n" +
            "冀ABP89挂\n" +
            "冀A3873Y\n" +
            "冀A99UJ挂\n" +
            "鲁VW5589\n" +
            "冀A98Q9挂\n" +
            "冀AL2921\n" +
            "冀A690N挂\n" +
            "冀ATL532\n" +
            "冀A3D69挂\n" +
            "冀A65119\n" +
            "冀AWF79挂\n" +
            "冀A5588U\n" +
            "冀A044M挂\n" +
            "冀A8155Y\n" +
            "赣CBS19挂\n" +
            "冀AX2331\n" +
            "粵AMC83挂\n" +
            "冀A72076\n" +
            "冀AMF44挂\n" +
            "粵ANZ80挂\n" +
            "粵ANP06挂\n" +
            "粵ANS11挂\n" +
            "鲁GP3039\n" +
            "鲁VX6395\n" +
            "鲁VV2769\n" +
            "鲁VX7356\n" +
            "鲁G3S28挂\n" +
            "鲁G6Y71挂\n" +
            "鲁G5Z83挂\n" +
            "鲁G2N73挂\n" +
            "赣C2M367\n" +
            "赣C6M588\n" +
            "赣CC5393\n" +
            "赣C8N706\n" +
            "赣CH5171\n" +
            "赣CC1572\n" +
            "赣CC1520\n" +
            "赣CH3901\n" +
            "赣CLJ77挂\n" +
            "赣CLW08挂\n" +
            "赣CLW13挂\n" +
            "赣CLZ79挂\n" +
            "赣CKP58挂\n" +
            "赣CLX77挂\n" +
            "赣CLT15挂\n" +
            "赣CLH93挂\n" +
            "粤SV1975\n" +
            "粤SY1522\n" +
            "粤SK8861\n" +
            "粤SL0763\n" +
            "粤SF2216\n" +
            "粤SN5216\n" +
            "桂C15158\n" +
            "桂C98379\n" +
            "桂BX5163\n" +
            "桂BE9368\n" +
            "粤SF7950\n" +
            "闽CA9276\n" +
            "闽DH8855\n" +
            "闽DH7772\n" +
            "粤SU650挂\n" +
            "粤BVT19挂\n" +
            "粤BVT09挂\n" +
            "粤SZ969挂\n" +
            "粤BK693挂\n" +
            "沪J6908挂\n" +
            "粤AZ442挂\n" +
            "闽CJ775挂\n" +
            "桂BD323挂\n" +
            "粤BX027挂\n" +
            "桂H0183挂\n" +
            "闽CG522挂\n" +
            "闽DCG87挂\n" +
            "闽DDW32挂\n" +
            "赣C5777Z\n" +
            "赣C9683Z\n" +
            "赣C3112Z\n" +
            "赣C3311Z\n" +
            "赣C6430Z\n" +
            "赣C9697Z\n" +
            "赣C0523Z\n" +
            "赣C8841Z\n" +
            "赣C4048Z\n" +
            "赣C9260Z\n" +
            "赣C3473Z\n" +
            "赣C3746Z\n" +
            "赣C0036Z\n" +
            "赣C2555Z\n" +
            "赣C1466Z\n" +
            "赣C6246Z\n" +
            "赣CBU05挂\n" +
            "赣CBWO2挂\n" +
            "赣CEF79挂\n" +
            "赣CEA41挂\n" +
            "赣CET86挂\n" +
            "赣CCL29挂\n" +
            "赣CCW63挂\n" +
            "赣CCW67挂\n" +
            "赣CBX17挂\n" +
            "赣CCW95挂\n" +
            "赣CBW25挂\n" +
            "赣C4Q170\n" +
            "赣C5Q040\n" +
            "赣C6Q458\n" +
            "苏H1193J\n" +
            "苏H7802U\n" +
            "沪AH638挂\n" +
            "粤BP889挂\n" +
            "粤BC330挂\n" +
            "粤BN259挂\n" +
            "沪K3228挂\n" +
            "沪K1036挂\n" +
            "吉A7090挂\n" +
            "吉AX718挂\n" +
            "吉AX844挂\n" +
            "吉AY552挂\n" +
            "吉AY721挂\n" +
            "吉AX785挂\n" +
            "吉AY372挂\n" +
            "吉AY567挂\n" +
            "吉AY916挂\n" +
            "吉AX372挂\n" +
            "吉AW548挂\n" +
            "吉AU086挂\n" +
            "吉A900A挂\n" +
            "吉AZ125挂\n" +
            "吉AZ681挂\n" +
            "吉A859B挂\n" +
            "吉A832A挂\n" +
            "吉AW737挂\n" +
            "吉AZ581挂\n" +
            "吉A111B挂\n" +
            "吉AW087挂\n" +
            "吉AW766挂\n" +
            "吉AR153挂\n" +
            "吉AQ128挂\n" +
            "吉AX657挂\n" +
            "吉AX952挂\n" +
            "吉AS890挂\n" +
            "吉AX228挂\n" +
            "吉AU768挂\n" +
            "吉AU778挂\n" +
            "吉AW333挂\n" +
            "吉AX847挂\n" +
            "辽H9X44挂\n" +
            "辽H7Q50挂\n" +
            "辽H3X92挂\n" +
            "辽H3Y02挂\n" +
            "辽H3V62挂\n" +
            "辽H2R60挂\n" +
            "辽HHP43挂\n" +
            "辽H8P33挂\n" +
            "辽H7R51挂\n" +
            "辽H9R37挂\n" +
            "辽H3W01挂\n" +
            "辽H2Q50挂\n" +
            "吉AX968挂\n" +
            "吉AY422挂\n" +
            "吉AY322挂\n" +
            "吉AY222挂\n" +
            "吉A003A挂\n" +
            "吉A000B挂\n" +
            "吉AZ776挂\n" +
            "吉A886B挂\n" +
            "吉AZ279挂\n" +
            "吉AZ833挂\n" +
            "吉A159D挂\n" +
            "吉A790D挂\n" +
            "吉A868D挂\n" +
            "吉A582C挂\n" +
            "吉A515D挂\n" +
            "吉A611D挂\n" +
            "吉A781F挂\n" +
            "吉A380F挂\n" +
            "吉A892E挂\n" +
            "赣CKA72挂\n" +
            "赣CFG90挂\n" +
            "赣CKW92挂\n" +
            "吉A856N挂\n" +
            "吉AQ587挂\n" +
            "吉A964E挂\n" +
            "吉A295R挂\n" +
            "吉A673J挂\n" +
            "吉A351E挂\n" +
            "吉A748R挂\n" +
            "吉A186K挂\n" +
            "吉A680N挂\n" +
            "吉A550L挂\n" +
            "吉A992P挂\n" +
            "吉A754F挂\n" +
            "吉A673K挂\n" +
            "吉AF121挂\n" +
            "吉A060P挂\n" +
            "吉A954Q挂\n" +
            "吉A232P挂\n" +
            "赣CHR00挂\n" +
            "赣CHY76挂\n" +
            "赣CKD87挂\n" +
            "吉A484A挂\n" +
            "吉A183S挂\n" +
            "吉A835S挂\n" +
            "吉A505R挂\n" +
            "吉A069N挂\n" +
            "吉A360U挂\n" +
            "吉A695T挂\n" +
            "吉A705U挂\n" +
            "吉A535U挂\n" +
            "吉A935Q挂\n" +
            "吉A665D挂\n" +
            "吉A070T挂\n" +
            "吉AX066挂\n" +
            "赣CLJ76挂\n" +
            "赣CKQ59挂\n" +
            "赣CLK49挂\n" +
            "赣CLR72挂\n" +
            "赣CKN71挂\n" +
            "赣CFL41挂\n" +
            "赣CKF38挂\n" +
            "赣CHH46挂\n" +
            "赣CKC46挂\n" +
            "赣CBS37挂\n" +
            "赣CBG23挂\n" +
            "赣CBS05挂\n" +
            "赣CBN51挂\n" +
            "赣CKT60挂\n" +
            "赣CKS42挂\n" +
            "赣CKQ47挂\n" +
            "赣CKW45挂\n" +
            "赣CLY15挂\n" +
            "赣CKQ40挂\n" +
            "赣CHD41挂\n" +
            "吉A385N挂\n" +
            "吉A682M挂\n" +
            "吉A586P挂\n" +
            "吉A993R挂\n" +
            "吉A227M挂\n" +
            "吉A758U挂\n" +
            "吉AX655挂\n" +
            "吉A922F挂\n" +
            "吉A509S挂\n" +
            "吉A672L挂\n" +
            "吉A553N挂\n" +
            "吉A090N挂\n" +
            "吉A913C挂\n" +
            "吉A494U挂\n" +
            "吉AJ721挂\n" +
            "吉A317F挂\n" +
            "吉A873F挂\n" +
            "吉A983F挂\n" +
            "吉A32HQ挂\n" +
            "吉A534H挂\n" +
            "吉A197L挂\n" +
            "吉A019R挂\n" +
            "吉A353L挂\n" +
            "吉AX073挂\n" +
            "吉A610Q挂\n" +
            "吉A988M挂\n" +
            "粤ST6716\n" +
            "粤BPD318\n" +
            "粤BKD643\n" +
            "粤BPG243\n" +
            "粤S77887\n" +
            "沪FH2160\n" +
            "粤SX9116\n" +
            "沪FE2682\n" +
            "粤SG031挂\n" +
            "粤S9566挂\n" +
            "粤BX451挂\n" +
            "粤BCB23挂\n" +
            "粤AF687挂\n" +
            "粤AR471挂\n" +
            "粤AM089挂\n" +
            "赣KG569挂\n" +
            "冀A1352C\n" +
            "冀A7940M\n" +
            "冀A6049Z\n" +
            "冀AS4186\n" +
            "冀AKG143\n" +
            "冀AY1667\n" +
            "冀A23375\n" +
            "冀A2102C\n" +
            "冀A254Z挂\n" +
            "冀AQ514挂\n" +
            "冀A17NC挂\n" +
            "冀AEP17挂\n" +
            "冀ARN67挂\n" +
            "冀AGQ76挂\n" +
            "冀A141T挂\n" +
            "冀AGL26挂\n" +
            "冀A85TW挂\n" +
            "冀A72XL挂\n" +
            "辽AEK382\n" +
            "辽ADG838\n" +
            "辽ADM331\n" +
            "辽ADX263\n" +
            "辽AEG131\n" +
            "辽AEC323\n" +
            "辽AEG582\n" +
            "辽AEH787\n" +
            "辽ADM355\n" +
            "辽AEN638\n" +
            "辽ACZ713\n" +
            "辽ADZ633\n" +
            "辽ACZ653\n" +
            "辽AEP738\n" +
            "辽 AEV558\n" +
            "辽ADN801\n" +
            "辽ADT388\n" +
            "辽ADD597\n" +
            "辽ADJ298\n" +
            "辽ADV981\n" +
            "辽AT000挂\n" +
            "辽AT269挂\n" +
            "辽AW978挂\n" +
            "辽AV708挂\n" +
            "辽AW282挂\n" +
            "辽AU335挂\n" +
            "辽AV993挂\n" +
            "辽AR123挂\n" +
            "辽AQ482挂\n" +
            "辽AU855挂\n" +
            "辽AW498挂\n" +
            "辽AV102挂\n" +
            "辽AV870挂\n" +
            "辽AT967挂\n" +
            "辽AU010挂\n" +
            "辽AT930挂\n" +
            "辽AU997挂\n" +
            "辽AU157挂\n" +
            "辽AW880挂\n" +
            "辽AT761挂\n" +
            "鄂A5K51挂\n" +
            "鄂A6Y20挂\n" +
            "冀E10FA挂\n" +
            "冀EYM04挂\n" +
            "冀E26GA挂\n" +
            "冀E92FG挂\n" +
            "晋MU072挂\n" +
            "晋MVP33挂\n" +
            "晋MA072挂\n" +
            "晋MDG69挂\n" +
            "晋MH455挂\n" +
            "晋MDN99挂\n" +
            "晋M0617挂\n" +
            "晋MYW23挂\n" +
            "辽AT000挂\n" +
            "辽AT269挂\n" +
            "辽AW978挂\n" +
            "辽AV708挂\n" +
            "辽AW282挂\n" +
            "辽AU335挂\n" +
            "辽AV993挂\n" +
            "辽AR123挂\n" +
            "辽AQ482挂\n" +
            "辽AU855挂\n" +
            "辽AW498挂\n" +
            "辽AV102挂\n" +
            "辽AV870挂\n" +
            "辽AT967挂\n" +
            "辽AU010挂\n" +
            "辽AT930挂\n" +
            "辽AU997挂\n" +
            "辽AU157挂\n" +
            "辽AW880挂\n" +
            "辽AT761挂\n" +
            "粤SG031挂\n" +
            "粤S9566挂\n" +
            "粤BX451挂\n" +
            "粤BCB23挂\n" +
            "粤AF687挂\n" +
            "粤AR471挂\n" +
            "粤AM089挂\n" +
            "赣KG569挂\n" +
            "赣CLG93挂\n" +
            "赣CLD73挂\n" +
            "赣CLF70挂\n" +
            "赣CLX01挂\n" +
            "赣CLR22挂\n" +
            "苏LE023挂\n" +
            "赣CLW41挂\n" +
            "苏LE268挂\n" +
            "赣F633B挂\n" +
            "鄂G2147挂\n" +
            "赣FB966挂\n" +
            "赣FC201挂\n" +
            "皖CGV16挂\n" +
            "皖CGA03挂\n" +
            "皖CGM78挂\n" +
            "皖CGM11挂\n" +
            "皖CGC98挂\n" +
            "皖CHH09挂\n" +
            "皖CX562挂\n" +
            "皖CEX78挂\n" +
            "皖CHA02挂\n" +
            "皖CGJ00挂\n" +
            "皖CHT33挂\n" +
            "皖CFQ41挂\n" +
            "皖CHL19挂\n" +
            "皖CGJ20挂\n" +
            "皖CR007挂\n" +
            "皖CQ118挂\n" +
            "皖CN453挂\n" +
            "鄂G2559挂\n" +
            "鄂G1621挂\n" +
            "鄂G1696挂\n" +
            "赣FC659挂\n" +
            "赣FD173挂\n" +
            "浙ACR36挂\n" +
            "京CS354挂\n" +
            "沪K0228挂\n" +
            "鲁DFF15挂\n" +
            "鲁DLT05挂\n" +
            "赣CLW80挂\n" +
            "赣CBP38挂\n" +
            "赣CLZ30挂\n" +
            "赣CLZ70挂\n" +
            "赣CBS32挂\n" +
            "赣CBS30挂\n" +
            "赣CLK81挂\n" +
            "赣CBS47挂\n" +
            "赣CLQ71挂\n" +
            "鲁DTQ59挂\n" +
            "沪K7968挂\n" +
            "赣CKC70挂\n" +
            "赣CKS41挂\n" +
            "赣CBJ11挂\n" +
            "沪L3952挂\n" +
            "赣CMQ13挂\n" +
            "鲁DFQ05挂\n" +
            "赣CKT46挂\n" +
            "鲁DDA71挂\n" +
            "鲁DFL89挂\n" +
            "沪AK031挂\n" +
            "鲁DFF72挂\n" +
            "鲁DV998挂\n" +
            "鲁DDH63挂\n" +
            "苏CS836挂\n" +
            "鲁DW395挂\n" +
            "鲁DDU83挂\n" +
            "赣CKY35挂\n" +
            "鲁DTZ80挂\n" +
            "赣CMZ80挂\n" +
            "鲁DCJ22挂\n" +
            "沪LF710挂\n" +
            "赣CBS81挂\n" +
            "鲁DRR01挂\n" +
            "赣CKH91挂\n" +
            "赣CKV41挂\n" +
            "鲁DTQ58挂\n" +
            "赣CBD27挂\n" +
            "赣CKR32挂\n" +
            "沪K2201挂\n" +
            "鲁DFQ82挂\n" +
            "鲁DMN63挂\n" +
            "鲁DDK09挂\n" +
            "赣CKL21挂\n" +
            "皖G8720挂\n" +
            "赣CKH45挂\n" +
            "鲁DLZ79挂\n" +
            "鲁DNC19挂\n" +
            "鲁DDM27挂\n" +
            "鲁DFD81挂\n" +
            "沪K2582挂\n" +
            "鲁DPL98挂\n" +
            "皖G8730挂\n" +
            "鲁DTQ56挂\n" +
            "赣CBQ61挂\n" +
            "鲁DV029挂\n" +
            "赣CNL11挂\n" +
            "鲁DFN17挂\n" +
            "鲁DSV55挂\n" +
            "鲁DTL82挂\n" +
            "鲁DV733挂\n" +
            "赣CBA90挂\n" +
            "鲁DTK07挂\n" +
            "鲁DW229挂\n" +
            "沪BY909挂\n" +
            "沪L2816挂\n" +
            "冀AAP64挂\n" +
            "冀AEN75挂\n" +
            "赣CBV31挂\n" +
            "赣CBQ12挂\n" +
            "冀A75SR挂\n" +
            "粤ANE77挂\n" +
            "冀A91AT挂\n" +
            "粤ANS11挂\n" +
            "粤ALB69挂\n" +
            "粤ANP06挂\n" +
            "冀A91CR挂";
}