package com.example.heretest;

import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoPolygon;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.mapviewlite.MapPolygon;
import com.here.sdk.mapviewlite.MapPolygonStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Locality25 {

    private ArrayList<GeoCoordinates> kochenevo() {
        ArrayList<GeoCoordinates> kochenevo = new ArrayList<>();
        kochenevo.add(new GeoCoordinates(55.066330, 82.219022)); //север
        kochenevo.add(new GeoCoordinates(55.005338, 82.278073)); //восток
        kochenevo.add(new GeoCoordinates(54.973429, 82.194989)); //юг
        kochenevo.add(new GeoCoordinates(55.021874, 82.134564)); //запад
        return kochenevo;
    }

    private ArrayList<GeoCoordinates> duplenskaya() {
        ArrayList<GeoCoordinates> duplenskaya = new ArrayList<>();
        duplenskaya.add(new GeoCoordinates(55.108969, 81.624937)); //север
        duplenskaya.add(new GeoCoordinates(55.089522, 81.651373)); //восток
        duplenskaya.add(new GeoCoordinates(55.074587, 81.619101)); //юг
        duplenskaya.add(new GeoCoordinates(55.087214, 81.591978)); //запад
        return duplenskaya;
    }

    private ArrayList<GeoCoordinates> kabinetnoe() {
        ArrayList<GeoCoordinates> kabinetnoe = new ArrayList<>();
        kabinetnoe.add(new GeoCoordinates(55.114904, 81.299279)); //север
        kabinetnoe.add(new GeoCoordinates(55.094871, 81.327432)); //восток
        kabinetnoe.add(new GeoCoordinates(55.074434, 81.286576)); //юг
        kabinetnoe.add(new GeoCoordinates(55.092513, 81.253274)); //запад
        return kabinetnoe;
    }

    private ArrayList<GeoCoordinates> chulym() {
        ArrayList<GeoCoordinates> chulym = new ArrayList<>();
        chulym.add(new GeoCoordinates(55.135876, 80.980158)); //север
        chulym.add(new GeoCoordinates(55.087568, 81.031313)); //восток
        chulym.add(new GeoCoordinates(55.060443, 80.933123)); //юг
        chulym.add(new GeoCoordinates(55.101320, 80.902224)); //запад
        return chulym;
    }

    private ArrayList<GeoCoordinates> verkhIrmen() {
        ArrayList<GeoCoordinates> verkhIrmen = new ArrayList<>();
        verkhIrmen.add(new GeoCoordinates(54.593833, 82.245724)); //север
        verkhIrmen.add(new GeoCoordinates(54.571947, 82.284176)); //восток
        verkhIrmen.add(new GeoCoordinates(54.553634, 82.243664)); //юг
        verkhIrmen.add(new GeoCoordinates(54.576326, 82.198345)); //запад
        return verkhIrmen;
    }

    private ArrayList<GeoCoordinates> krasnyiYar() {
        ArrayList<GeoCoordinates> krasnyiYar = new ArrayList<>();
        krasnyiYar.add(new GeoCoordinates(54.470876, 82.156555)); //север
        krasnyiYar.add(new GeoCoordinates(54.454912, 82.181961)); //восток
        krasnyiYar.add(new GeoCoordinates(54.439740, 82.146942)); //юг
        krasnyiYar.add(new GeoCoordinates(54.452517, 82.124282)); //запад
        return krasnyiYar;
    }

    private ArrayList<GeoCoordinates> ordynskoe() {
        ArrayList<GeoCoordinates> ordynskoe = new ArrayList<>();
        ordynskoe.add(new GeoCoordinates(54.392056, 81.880875)); //север
        ordynskoe.add(new GeoCoordinates(54.377261, 81.983185)); //восток
        ordynskoe.add(new GeoCoordinates(54.334046, 81.878815)); //юг
        ordynskoe.add(new GeoCoordinates(54.337248, 81.783371)); //запад
        return ordynskoe;
    }

    private ArrayList<GeoCoordinates> spirino() {
        ArrayList<GeoCoordinates> spirino = new ArrayList<>();
        spirino.add(new GeoCoordinates(54.149323, 81.571452)); //север
        spirino.add(new GeoCoordinates(54.141883, 81.589991)); //восток
        spirino.add(new GeoCoordinates(54.120761, 81.535746)); //юг
        spirino.add(new GeoCoordinates(54.126797, 81.525790)); //запад
        return spirino;
    }

    private ArrayList<GeoCoordinates> iskitim() {
        ArrayList<GeoCoordinates> iskitim = new ArrayList<>();
        iskitim.add(new GeoCoordinates(54.664792, 83.221584)); //север
        iskitim.add(new GeoCoordinates(54.656451, 83.325955)); //восток
        iskitim.add(new GeoCoordinates(54.550258, 83.323723)); //юг
        iskitim.add(new GeoCoordinates(54.619196, 83.192745)); //запад
        return iskitim;
    }

    private ArrayList<GeoCoordinates> linevo() {
        ArrayList<GeoCoordinates> linevo = new ArrayList<>();
        linevo.add(new GeoCoordinates(54.501115, 83.352884)); //север
        linevo.add(new GeoCoordinates(54.462420, 83.431504)); //восток
        linevo.add(new GeoCoordinates(54.436071, 83.383096)); //юг
        linevo.add(new GeoCoordinates(54.474591, 83.317865)); //запад
        return linevo;
    }

    private ArrayList<GeoCoordinates> dorogino() {
        ArrayList<GeoCoordinates> dorogino = new ArrayList<>();
        dorogino.add(new GeoCoordinates(54.383885, 83.331481)); //север
        dorogino.add(new GeoCoordinates(54.361086, 83.346931)); //восток
        dorogino.add(new GeoCoordinates(54.348682, 83.318435)); //юг
        dorogino.add(new GeoCoordinates(54.370687, 83.289253)); //запад
        return dorogino;
    }

    private ArrayList<GeoCoordinates> medvedskoe() {
        ArrayList<GeoCoordinates> medvedskoe = new ArrayList<>();
        medvedskoe.add(new GeoCoordinates(54.421064, 83.564501)); //север
        medvedskoe.add(new GeoCoordinates(54.402682, 83.588534)); //восток
        medvedskoe.add(new GeoCoordinates(54.382493, 83.552142)); //юг
        medvedskoe.add(new GeoCoordinates(54.401283, 83.531542)); //запад
        return medvedskoe;
    }

    private ArrayList<GeoCoordinates> cherepanovo() {
        ArrayList<GeoCoordinates> cherepanovo = new ArrayList<>();
        cherepanovo.add(new GeoCoordinates(54.265815, 83.382638)); //север
        cherepanovo.add(new GeoCoordinates(54.227299, 83.442376)); //восток
        cherepanovo.add(new GeoCoordinates(54.171066, 83.330453)); //юг
        cherepanovo.add(new GeoCoordinates(54.235326, 83.300240)); //запад
        return cherepanovo;
    }

    private ArrayList<GeoCoordinates> bezmenovo() {
        ArrayList<GeoCoordinates> bezmenovo = new ArrayList<>();
        bezmenovo.add(new GeoCoordinates(54.109889, 83.395668)); //север
        bezmenovo.add(new GeoCoordinates(54.078479, 83.434120)); //восток
        bezmenovo.add(new GeoCoordinates(54.045030, 83.363395)); //юг
        bezmenovo.add(new GeoCoordinates(54.070825, 83.338676)); //запад
        return bezmenovo;
    }

    private ArrayList<GeoCoordinates> karpysak() {
        ArrayList<GeoCoordinates> karpysak = new ArrayList<>();
        karpysak.add(new GeoCoordinates(55.059069, 83.724183)); //север
        karpysak.add(new GeoCoordinates(55.047269, 83.745469)); //восток
        karpysak.add(new GeoCoordinates(55.024053, 83.698090)); //юг
        karpysak.add(new GeoCoordinates(55.042549, 83.678178)); //запад
        return karpysak;
    }

    private ArrayList<GeoCoordinates> gornyi() {
        ArrayList<GeoCoordinates> gornyi = new ArrayList<>();
        gornyi.add(new GeoCoordinates(55.154920, 83.912347)); //север
        gornyi.add(new GeoCoordinates(55.124307, 83.966592)); //восток
        gornyi.add(new GeoCoordinates(55.089349, 83.884195)); //юг
        gornyi.add(new GeoCoordinates(55.120774, 83.831323)); //запад
        return gornyi;
    }

    private ArrayList<GeoCoordinates> ustKamenka() {
        ArrayList<GeoCoordinates> ustKamenka = new ArrayList<>();
        ustKamenka.add(new GeoCoordinates(55.021160, 83.852539)); //север
        ustKamenka.add(new GeoCoordinates(54.990051, 83.880692)); //восток
        ustKamenka.add(new GeoCoordinates(54.985717, 83.835373)); //юг
        ustKamenka.add(new GeoCoordinates(55.006593, 83.818893)); //запад
        return ustKamenka;
    }

    private ArrayList<GeoCoordinates> vladimirovka() {
        ArrayList<GeoCoordinates> vladimirovka = new ArrayList<>();
        vladimirovka.add(new GeoCoordinates(54.975204, 84.004339)); //север
        vladimirovka.add(new GeoCoordinates(54.959240, 84.022192)); //восток
        vladimirovka.add(new GeoCoordinates(54.948200, 83.982023)); //юг
        vladimirovka.add(new GeoCoordinates(54.960423, 83.970693)); //запад
        return vladimirovka;
    }

    private ArrayList<GeoCoordinates> lebedevo() {
        ArrayList<GeoCoordinates> lebedevo = new ArrayList<>();
        lebedevo.add(new GeoCoordinates(54.937969, 84.350064)); //север
        lebedevo.add(new GeoCoordinates(54.910348, 84.372036)); //восток
        lebedevo.add(new GeoCoordinates(54.904032, 84.327404)); //юг
        lebedevo.add(new GeoCoordinates(54.923372, 84.306805)); //запад
        return lebedevo;
    }

    private ArrayList<GeoCoordinates> toguchin() {
        ArrayList<GeoCoordinates> toguchin = new ArrayList<>();
        toguchin.add(new GeoCoordinates(55.276399, 84.404401)); //север
        toguchin.add(new GeoCoordinates(55.223953, 84.468259)); //восток
        toguchin.add(new GeoCoordinates(55.213770, 84.348096)); //юг
        toguchin.add(new GeoCoordinates(55.255273, 84.317883)); //запад
        return toguchin;
    }

    private ArrayList<GeoCoordinates> kolyvan() {
        ArrayList<GeoCoordinates> kolyvan = new ArrayList<>();
        kolyvan.add(new GeoCoordinates(55.339116, 82.747877)); //север
        kolyvan.add(new GeoCoordinates(55.303955, 82.795255)); //восток
        kolyvan.add(new GeoCoordinates(55.279714, 82.690199)); //юг
        kolyvan.add(new GeoCoordinates(55.322321, 82.695005)); //запад
        return kolyvan;
    }

    private ArrayList<GeoCoordinates> moshkovo() {
        ArrayList<GeoCoordinates> moshkovo = new ArrayList<>();
        moshkovo.add(new GeoCoordinates(55.337234, 83.638332)); //север
        moshkovo.add(new GeoCoordinates(55.294644, 83.669918)); //восток
        moshkovo.add(new GeoCoordinates(55.284869, 83.563488)); //юг
        moshkovo.add(new GeoCoordinates(55.319657, 83.574474)); //запад
        return moshkovo;
    }

    private ArrayList<GeoCoordinates> stancionnoOyashinskiy() {
        ArrayList<GeoCoordinates> stancionnoOyashinskiy = new ArrayList<>();
        stancionnoOyashinskiy.add(new GeoCoordinates(55.506028, 83.831018)); //север
        stancionnoOyashinskiy.add(new GeoCoordinates(55.466345, 83.872217)); //восток
        stancionnoOyashinskiy.add(new GeoCoordinates(55.442204, 83.811105)); //юг
        stancionnoOyashinskiy.add(new GeoCoordinates(55.501362, 83.714975)); //запад
        return stancionnoOyashinskiy;
    }

    private ArrayList<GeoCoordinates> tashara() {
        ArrayList<GeoCoordinates> tashara = new ArrayList<>();
        tashara.add(new GeoCoordinates(55.542136, 83.524352)); //север
        tashara.add(new GeoCoordinates(55.528730, 83.544264)); //восток
        tashara.add(new GeoCoordinates(55.497627, 83.499289)); //юг
        tashara.add(new GeoCoordinates(55.514542, 83.462210)); //запад
        return tashara;
    }

    private ArrayList<GeoCoordinates> bolotnoe() {
        ArrayList<GeoCoordinates> bolotnoe = new ArrayList<>();
        bolotnoe.add(new GeoCoordinates(55.710680, 84.409019)); //север
        bolotnoe.add(new GeoCoordinates(55.673526, 84.470817)); //восток
        bolotnoe.add(new GeoCoordinates(55.630135, 84.371940)); //юг
        bolotnoe.add(new GeoCoordinates(55.678172, 84.301902)); //запад
        return bolotnoe;
    }

    private ArrayList<GeoCoordinates> pikhtovka() {
        ArrayList<GeoCoordinates> pikhtovka = new ArrayList<>();
        pikhtovka.add(new GeoCoordinates(56.039092, 82.697947)); //север
        pikhtovka.add(new GeoCoordinates(56.005323, 82.752192)); //восток
        pikhtovka.add(new GeoCoordinates(55.978439, 82.709276)); //юг
        pikhtovka.add(new GeoCoordinates(56.009929, 82.655031)); //запад
        return pikhtovka;
    }

    private ArrayList<GeoCoordinates> bazoy() {
        ArrayList<GeoCoordinates> bazoy = new ArrayList<>();
        bazoy.add(new GeoCoordinates(55.762665, 83.365003)); //север
        bazoy.add(new GeoCoordinates(55.749141, 83.392297)); //восток
        bazoy.add(new GeoCoordinates(55.733197, 83.361913)); //юг
        bazoy.add(new GeoCoordinates(55.749431, 83.341657)); //запад
        return bazoy;
    }

    private ArrayList<GeoCoordinates> kokosheno() {
        ArrayList<GeoCoordinates> kokosheno = new ArrayList<>();
        kokosheno.add(new GeoCoordinates(55.171679, 80.625291)); //север
        kokosheno.add(new GeoCoordinates(55.150105, 80.657220)); //восток
        kokosheno.add(new GeoCoordinates(55.126359, 80.620828)); //юг
        kokosheno.add(new GeoCoordinates(55.155597, 80.594735)); //запад
        return kokosheno;
    }

    private ArrayList<GeoCoordinates> kargat() {
        ArrayList<GeoCoordinates> kargat = new ArrayList<>();
        kargat.add(new GeoCoordinates(55.256060, 80.291600)); //север
        kargat.add(new GeoCoordinates(55.200453, 80.386358)); //восток
        kargat.add(new GeoCoordinates(55.150262, 80.276494)); //юг
        kargat.add(new GeoCoordinates(55.188695, 80.184484)); //запад
        return kargat;
    }

    private ArrayList<GeoCoordinates> proletarskiy() {
        ArrayList<GeoCoordinates> proletarskiy = new ArrayList<>();
        proletarskiy.add(new GeoCoordinates(54.396062, 81.165744)); //север
        proletarskiy.add(new GeoCoordinates(54.381468, 81.178104)); //восток
        proletarskiy.add(new GeoCoordinates(54.375269, 81.155101)); //юг
        proletarskiy.add(new GeoCoordinates(54.386667, 81.144458)); //запад
        return proletarskiy;
    }

    private ArrayList<GeoCoordinates> krutikha() {
        ArrayList<GeoCoordinates> krutikha = new ArrayList<>();
        krutikha.add(new GeoCoordinates(53.986525, 81.208377)); //север
        krutikha.add(new GeoCoordinates(53.962900, 81.228805)); //восток
        krutikha.add(new GeoCoordinates(53.946435, 81.200137)); //юг
        krutikha.add(new GeoCoordinates(53.966637, 81.181769)); //запад
        return krutikha;
    }

    private ArrayList<GeoCoordinates> bystrukha() {
        ArrayList<GeoCoordinates> bystrukha = new ArrayList<>();
        bystrukha.add(new GeoCoordinates(54.451085, 80.889791)); //север
        bystrukha.add(new GeoCoordinates(54.438108, 80.915197)); //восток
        bystrukha.add(new GeoCoordinates(54.414740, 80.867819)); //юг
        bystrukha.add(new GeoCoordinates(54.431519, 80.838980)); //запад
        return bystrukha;
    }

    private ArrayList<GeoCoordinates> zhulanka() {
        ArrayList<GeoCoordinates> zhulanka = new ArrayList<>();
        zhulanka.add(new GeoCoordinates(54.386480, 80.624771)); //север
        zhulanka.add(new GeoCoordinates(54.366483, 80.648804)); //восток
        zhulanka.add(new GeoCoordinates(54.343274, 80.584946)); //юг
        zhulanka.add(new GeoCoordinates(54.368083, 80.569839)); //запад
        return zhulanka;
    }

    private ArrayList<GeoCoordinates> kamenNaObi() {
        ArrayList<GeoCoordinates> kamenNaObi = new ArrayList<>();
        kamenNaObi.add(new GeoCoordinates(53.833332, 81.321355)); //север
        kamenNaObi.add(new GeoCoordinates(53.775752, 81.385900)); //восток
        kamenNaObi.add(new GeoCoordinates(53.743278, 81.332342)); //юг
        kamenNaObi.add(new GeoCoordinates(53.791169, 81.233465)); //запад
        return kamenNaObi;
    }

    private ArrayList<GeoCoordinates> talmenka() {
        ArrayList<GeoCoordinates> talmenka = new ArrayList<>();
        talmenka.add(new GeoCoordinates(53.844717, 83.563199)); //север
        talmenka.add(new GeoCoordinates(53.832562, 83.640103)); //восток
        talmenka.add(new GeoCoordinates(53.795670, 83.568005)); //юг
        talmenka.add(new GeoCoordinates(53.803376, 83.493161)); //запад
        return talmenka;
    }

    private ArrayList<GeoCoordinates> maslyanino() {
        ArrayList<GeoCoordinates> maslyanino = new ArrayList<>();
        maslyanino.add(new GeoCoordinates(54.384269, 84.213212)); //север
        maslyanino.add(new GeoCoordinates(54.318238, 84.332688)); //восток
        maslyanino.add(new GeoCoordinates(54.292197, 84.226945)); //юг
        maslyanino.add(new GeoCoordinates(54.353068, 84.117082)); //запад
        return maslyanino;
    }

    private ArrayList<GeoCoordinates> sibirskiy() {
        ArrayList<GeoCoordinates> sibirskiy = new ArrayList<>();
        sibirskiy.add(new GeoCoordinates(53.563088, 83.839685)); //север
        sibirskiy.add(new GeoCoordinates(53.557429, 83.846637)); //восток
        sibirskiy.add(new GeoCoordinates(53.553401, 83.838912)); //юг
        sibirskiy.add(new GeoCoordinates(53.557486, 83.828462)); //запад
        return sibirskiy;
    }

    private ArrayList<GeoCoordinates> zhuravlevo() {
        ArrayList<GeoCoordinates> zhuravlevo = new ArrayList<>();
        zhuravlevo.add(new GeoCoordinates(54.795213, 85.068007)); //север
        zhuravlevo.add(new GeoCoordinates(54.778633, 85.086289)); //восток
        zhuravlevo.add(new GeoCoordinates(54.768137, 85.067578)); //юг
        zhuravlevo.add(new GeoCoordinates(54.788532, 85.035477)); //запад
        return zhuravlevo;
    }

    private ArrayList<GeoCoordinates> vaganovo() {
        ArrayList<GeoCoordinates> vaganovo = new ArrayList<>();
        vaganovo.add(new GeoCoordinates(54.713611, 85.171479)); //север
        vaganovo.add(new GeoCoordinates(54.700916, 85.199116)); //восток
        vaganovo.add(new GeoCoordinates(54.671644, 85.163411)); //юг
        vaganovo.add(new GeoCoordinates(54.696552, 85.140580)); //запад
        return vaganovo;
    }

    private ArrayList<GeoCoordinates> krasnoe() {
        ArrayList<GeoCoordinates> krasnoe = new ArrayList<>();
        krasnoe.add(new GeoCoordinates(54.623278, 85.397664)); //север
        krasnoe.add(new GeoCoordinates(54.603596, 85.421010)); //восток
        krasnoe.add(new GeoCoordinates(54.586888, 85.366422)); //юг
        krasnoe.add(new GeoCoordinates(54.612146, 85.326940)); //запад
        return krasnoe;
    }

    private ArrayList<GeoCoordinates> urga() {
        ArrayList<GeoCoordinates> urga = new ArrayList<>();
        urga.add(new GeoCoordinates(55.758642, 84.906187)); //север
        urga.add(new GeoCoordinates(55.697162, 85.005064)); //восток
        urga.add(new GeoCoordinates(55.675873, 84.944639)); //юг
        urga.add(new GeoCoordinates(55.726947, 84.772978)); //запад
        return urga;
    }

    private ArrayList<GeoCoordinates> kozhevnikovo() {
        ArrayList<GeoCoordinates> kozhevnikovo = new ArrayList<>();
        kozhevnikovo.add(new GeoCoordinates(56.285889, 83.968684)); //север
        kozhevnikovo.add(new GeoCoordinates(56.261490, 83.996836)); //восток
        kozhevnikovo.add(new GeoCoordinates(56.230014, 83.973147)); //юг
        kozhevnikovo.add(new GeoCoordinates(56.260536, 83.923365)); //запад
        return kozhevnikovo;
    }

    private ArrayList<GeoCoordinates> ubinskoe() {
        ArrayList<GeoCoordinates> ubinskoe = new ArrayList<>();
        ubinskoe.add(new GeoCoordinates(55.342712, 79.686077)); //север
        ubinskoe.add(new GeoCoordinates(55.287617, 79.734829)); //восток
        ubinskoe.add(new GeoCoordinates(55.280579, 79.648655)); //юг
        ubinskoe.add(new GeoCoordinates(55.325332, 79.618099)); //запад
        return ubinskoe;
    }

    private ArrayList<GeoCoordinates> dovolnoe() {
        ArrayList<GeoCoordinates> dovolnoe = new ArrayList<>();
        dovolnoe.add(new GeoCoordinates(54.520382, 79.731710)); //север
        dovolnoe.add(new GeoCoordinates(54.488885, 79.735830)); //восток
        dovolnoe.add(new GeoCoordinates(54.475521, 79.632833)); //юг
        dovolnoe.add(new GeoCoordinates(54.502443, 79.630086)); //запад
        return dovolnoe;
    }

    private ArrayList<GeoCoordinates> barabinsk() {
        ArrayList<GeoCoordinates> barabinsk = new ArrayList<>();
        barabinsk.add(new GeoCoordinates(55.385114, 78.350214)); //север
        barabinsk.add(new GeoCoordinates(55.362094, 78.430895)); //восток
        barabinsk.add(new GeoCoordinates(55.319140, 78.356050)); //юг
        barabinsk.add(new GeoCoordinates(55.343942, 78.249277)); //запад
        return barabinsk;
    }

    private ArrayList<GeoCoordinates> kuibyshev() {
        ArrayList<GeoCoordinates> kuibyshev = new ArrayList<>();
        kuibyshev.add(new GeoCoordinates(55.490665, 78.285455)); //север
        kuibyshev.add(new GeoCoordinates(55.455249, 78.412141)); //восток
        kuibyshev.add(new GeoCoordinates(55.418632, 78.325967)); //юг
        kuibyshev.add(new GeoCoordinates(55.445903, 78.226404)); //запад
        return kuibyshev;
    }

    private ArrayList<GeoCoordinates> chany() {
        ArrayList<GeoCoordinates> chany = new ArrayList<>();
        chany.add(new GeoCoordinates(55.331246, 76.816477)); //север
        chany.add(new GeoCoordinates(55.310931, 76.825747)); //восток
        chany.add(new GeoCoordinates(55.288650, 76.749529)); //юг
        chany.add(new GeoCoordinates(55.313080, 76.710391)); //запад
        return chany;
    }

    private ArrayList<GeoCoordinates> bagan() {
        ArrayList<GeoCoordinates> bagan = new ArrayList<>();
        bagan.add(new GeoCoordinates(54.119561, 77.710876)); //север
        bagan.add(new GeoCoordinates(54.082922, 77.725295)); //восток
        bagan.add(new GeoCoordinates(54.077887, 77.635002)); //юг
        bagan.add(new GeoCoordinates(54.112316, 77.625045)); //запад
        return bagan;
    }

    private ArrayList<GeoCoordinates> vengerovo() {
        ArrayList<GeoCoordinates> vengerovo = new ArrayList<>();
        vengerovo.add(new GeoCoordinates(55.705577, 76.757619)); //север
        vengerovo.add(new GeoCoordinates(55.685453, 76.802937)); //восток
        vengerovo.add(new GeoCoordinates(55.664545, 76.750066)); //юг
        vengerovo.add(new GeoCoordinates(55.680227, 76.693417)); //запад
        return vengerovo;
    }

    private ArrayList<GeoCoordinates> tatarsk() {
        ArrayList<GeoCoordinates> tatarsk = new ArrayList<>();
        tatarsk.add(new GeoCoordinates(55.245267, 76.043146)); //север
        tatarsk.add(new GeoCoordinates(55.183765, 76.076105)); //восток
        tatarsk.add(new GeoCoordinates(55.159451, 75.912683)); //юг
        tatarsk.add(new GeoCoordinates(55.232348, 75.872858)); //запад
        return tatarsk;
    }

    private ArrayList<GeoCoordinates> kupino() {
        ArrayList<GeoCoordinates> kupino = new ArrayList<>();
        kupino.add(new GeoCoordinates(54.402543, 77.306579)); //север
        kupino.add(new GeoCoordinates(54.379554, 77.408203)); //восток
        kupino.add(new GeoCoordinates(54.346148, 77.296966)); //юг
        kupino.add(new GeoCoordinates(54.367755, 77.203926)); //запад
        return kupino;
    }

    private ArrayList<GeoCoordinates> chistoozernoe() {
        ArrayList<GeoCoordinates> chistoozernoe = new ArrayList<>();
        chistoozernoe.add(new GeoCoordinates(54.735016, 76.572959)); //север
        chistoozernoe.add(new GeoCoordinates(54.735016, 76.572959)); //восток
        chistoozernoe.add(new GeoCoordinates(54.686026, 76.579482)); //юг
        chistoozernoe.add(new GeoCoordinates(54.718758, 76.528327)); //запад
        return chistoozernoe;
    }

    private ArrayList<GeoCoordinates> omsk() {
        ArrayList<GeoCoordinates> omsk = new ArrayList<>();
        omsk.add(new GeoCoordinates(55.189120, 73.238009)); //север
        omsk.add(new GeoCoordinates(54.998160, 73.702181)); //восток
        omsk.add(new GeoCoordinates(54.802328, 73.362979)); //юг
        omsk.add(new GeoCoordinates(55.023359, 72.996310)); //запад
        return omsk;
    }

    private ArrayList<GeoCoordinates> ishim() {
        ArrayList<GeoCoordinates> ishim = new ArrayList<>();
        ishim.add(new GeoCoordinates(56.152122, 69.530612)); //север
        ishim.add(new GeoCoordinates(56.102371, 69.560825)); //восток
        ishim.add(new GeoCoordinates(56.081686, 69.376804)); //юг
        ishim.add(new GeoCoordinates(56.113475, 69.363758)); //запад
        return ishim;
    }

    private ArrayList<GeoCoordinates> tumen() {
        ArrayList<GeoCoordinates> tumen = new ArrayList<>();
        tumen.add(new GeoCoordinates(57.284022, 65.736788)); //север
        tumen.add(new GeoCoordinates(57.059932, 65.827425)); //восток
        tumen.add(new GeoCoordinates(57.122605, 65.302828)); //юг
        tumen.add(new GeoCoordinates(57.300347, 65.389345)); //запад
        return tumen;
    }

    private ArrayList<GeoCoordinates> kurgan() {
        ArrayList<GeoCoordinates> kurgan = new ArrayList<>();
        kurgan.add(new GeoCoordinates(55.519336, 65.331164)); //север
        kurgan.add(new GeoCoordinates(55.480443, 65.479479)); //восток
        kurgan.add(new GeoCoordinates(55.385385, 65.203448)); //юг
        kurgan.add(new GeoCoordinates(55.496005, 65.178729)); //запад
        return kurgan;
    }

    private ArrayList<GeoCoordinates> chelyabinsk() {
        ArrayList<GeoCoordinates> chelyabinsk = new ArrayList<>();
        chelyabinsk.add(new GeoCoordinates(55.383285, 61.430516)); //север
        chelyabinsk.add(new GeoCoordinates(55.183848, 61.674962)); //восток
        chelyabinsk.add(new GeoCoordinates(54.970008, 61.323400)); //юг
        chelyabinsk.add(new GeoCoordinates(55.207363, 61.169591)); //запад
        return chelyabinsk;
    }

    private ArrayList<GeoCoordinates> ekaterinburg() {
        ArrayList<GeoCoordinates> ekaterinburg = new ArrayList<>();
        ekaterinburg.add(new GeoCoordinates(57.029440, 60.637055)); //север
        ekaterinburg.add(new GeoCoordinates(56.760169, 60.935059)); //восток
        ekaterinburg.add(new GeoCoordinates(56.666711, 60.621949)); //юг
        ekaterinburg.add(new GeoCoordinates(56.905171, 60.367890)); //запад
        return ekaterinburg;
    }

    private ArrayList<GeoCoordinates> kochki() {
        ArrayList<GeoCoordinates> kochki = new ArrayList<>();
        kochki.add(new GeoCoordinates(54.368020, 80.496379)); //север
        kochki.add(new GeoCoordinates(54.347514, 80.536548)); //восток
        kochki.add(new GeoCoordinates(54.321892, 80.473205)); //юг
        kochki.add(new GeoCoordinates(54.339108, 80.447284)); //запад
        return kochki;
    }

    private ArrayList<GeoCoordinates> pankrushikha() {
        ArrayList<GeoCoordinates> pankrushikha = new ArrayList<>();
        pankrushikha.add(new GeoCoordinates(53.843298, 80.365398)); //север
        pankrushikha.add(new GeoCoordinates(53.823037, 80.393893)); //восток
        pankrushikha.add(new GeoCoordinates(53.804490, 80.332954)); //юг
        pankrushikha.add(new GeoCoordinates(53.821619, 80.310981)); //запад
        return pankrushikha;
    }

    private ArrayList<GeoCoordinates> baevo() {
        ArrayList<GeoCoordinates> baevo = new ArrayList<>();
        baevo.add(new GeoCoordinates(53.289988, 80.789761)); //север
        baevo.add(new GeoCoordinates(53.268537, 80.819116)); //восток
        baevo.add(new GeoCoordinates(53.249848, 80.747704)); //юг
        baevo.add(new GeoCoordinates(53.275825, 80.730023)); //запад
        return baevo;
    }

    private ArrayList<GeoCoordinates> krasnozerskoe() {
        ArrayList<GeoCoordinates> krasnozerskoe = new ArrayList<>();
        krasnozerskoe.add(new GeoCoordinates(54.030707, 79.318200)); //север
        krasnozerskoe.add(new GeoCoordinates(53.986320, 79.348069)); //восток
        krasnozerskoe.add(new GeoCoordinates(53.972389, 79.184991)); //юг
        krasnozerskoe.add(new GeoCoordinates(54.013966, 79.162332)); //запад
        return krasnozerskoe;
    }

    private ArrayList<GeoCoordinates> khabary() {
        ArrayList<GeoCoordinates> khabary = new ArrayList<>();
        khabary.add(new GeoCoordinates(53.656935, 79.579693)); //север
        khabary.add(new GeoCoordinates(53.598705, 79.604240)); //восток
        khabary.add(new GeoCoordinates(53.604817, 79.498840)); //юг
        khabary.add(new GeoCoordinates(53.628848, 79.490772)); //запад
        return khabary;
    }

    private ArrayList<GeoCoordinates> zavyalovo() {
        ArrayList<GeoCoordinates> zavyalovo = new ArrayList<>();
        zavyalovo.add(new GeoCoordinates(52.872064, 80.943498)); //север
        zavyalovo.add(new GeoCoordinates(52.826865, 80.973024)); //восток
        zavyalovo.add(new GeoCoordinates(52.804455, 80.862474)); //юг
        zavyalovo.add(new GeoCoordinates(52.844701, 80.821962)); //запад
        return zavyalovo;
    }

    private ArrayList<GeoCoordinates> golbshtadt() {
        ArrayList<GeoCoordinates> golbshtadt = new ArrayList<>();
        golbshtadt.add(new GeoCoordinates(53.241393, 78.988755)); //север
        golbshtadt.add(new GeoCoordinates(53.221562, 79.009697)); //восток
        golbshtadt.add(new GeoCoordinates(53.214675, 78.979657)); //юг
        golbshtadt.add(new GeoCoordinates(53.232044, 78.971309)); //запад
        return golbshtadt;
    }

    private ArrayList<GeoCoordinates> romanovo() {
        ArrayList<GeoCoordinates> romanovo = new ArrayList<>();
        romanovo.add(new GeoCoordinates(52.645926, 81.223851)); //север
        romanovo.add(new GeoCoordinates(52.635510, 81.291829)); //восток
        romanovo.add(new GeoCoordinates(52.592984, 81.211491)); //юг
        romanovo.add(new GeoCoordinates(52.624674, 81.179562)); //запад
        return romanovo;
    }

    private ArrayList<GeoCoordinates> karasuk() {
        ArrayList<GeoCoordinates> karasuk = new ArrayList<>();
        karasuk.add(new GeoCoordinates(53.760221, 78.016368)); //север
        karasuk.add(new GeoCoordinates(53.730781, 78.115245)); //восток
        karasuk.add(new GeoCoordinates(53.681805, 77.978603)); //юг
        karasuk.add(new GeoCoordinates(53.737686, 77.909938)); //запад
        return karasuk;
    }

    private ArrayList<GeoCoordinates> slavgorod() {
        ArrayList<GeoCoordinates> slavgorod = new ArrayList<>();
        slavgorod.add(new GeoCoordinates(53.045848, 78.655132)); //север
        slavgorod.add(new GeoCoordinates(53.012811, 78.715214)); //восток
        slavgorod.add(new GeoCoordinates(52.957833, 78.655475)); //юг
        slavgorod.add(new GeoCoordinates(52.995044, 78.574451)); //запад
        return slavgorod;
    }

    private ArrayList<GeoCoordinates> yarovoe() {
        ArrayList<GeoCoordinates> yarovoe = new ArrayList<>();
        yarovoe.add(new GeoCoordinates(52.951604, 78.587299)); //север
        yarovoe.add(new GeoCoordinates(52.917771, 78.610301)); //восток
        yarovoe.add(new GeoCoordinates(52.907419, 78.558460)); //юг
        yarovoe.add(new GeoCoordinates(52.935156, 78.538032)); //запад
        return yarovoe;
    }

    private ArrayList<GeoCoordinates> mamontovo() {
        ArrayList<GeoCoordinates> mamontovo = new ArrayList<>();
        mamontovo.add(new GeoCoordinates(52.744673, 81.612493)); //север
        mamontovo.add(new GeoCoordinates(52.712030, 81.661245)); //восток
        mamontovo.add(new GeoCoordinates(52.665207, 81.574728)); //юг
        mamontovo.add(new GeoCoordinates(52.703918, 81.517050)); //запад
        return mamontovo;
    }

    private ArrayList<GeoCoordinates> blagoveshenka() {
        ArrayList<GeoCoordinates> blagoveshenka = new ArrayList<>();
        blagoveshenka.add(new GeoCoordinates(52.857107, 79.878489)); //север
        blagoveshenka.add(new GeoCoordinates(52.819777, 79.960200)); //восток
        blagoveshenka.add(new GeoCoordinates(52.811892, 79.863040)); //юг
        blagoveshenka.add(new GeoCoordinates(52.835543, 79.831797)); //запад
        return blagoveshenka;
    }

    private ArrayList<GeoCoordinates> tabuny() {
        ArrayList<GeoCoordinates> tabuny = new ArrayList<>();
        tabuny.add(new GeoCoordinates(52.805299, 78.814024)); //север
        tabuny.add(new GeoCoordinates(52.757744, 78.850073)); //восток
        tabuny.add(new GeoCoordinates(52.740080, 78.770422)); //юг
        tabuny.add(new GeoCoordinates(52.792221, 78.738493)); //запад
        return tabuny;
    }

    private ArrayList<GeoCoordinates> rodino() {
        ArrayList<GeoCoordinates> rodino = new ArrayList<>();
        rodino.add(new GeoCoordinates(52.534544, 80.262423)); //север
        rodino.add(new GeoCoordinates(52.488158, 80.280963)); //восток
        rodino.add(new GeoCoordinates(52.473939, 80.130587)); //юг
        rodino.add(new GeoCoordinates(52.519923, 80.112048)); //запад
        return rodino;
    }

    private ArrayList<GeoCoordinates> kulunda() {
        ArrayList<GeoCoordinates> kulunda = new ArrayList<>();
        kulunda.add(new GeoCoordinates(52.604963, 78.962846)); //север
        kulunda.add(new GeoCoordinates(52.550301, 79.001298)); //восток
        kulunda.add(new GeoCoordinates(52.533179, 78.896241)); //юг
        kulunda.add(new GeoCoordinates(52.589114, 78.841310)); //запад
        return kulunda;
    }

    private ArrayList<GeoCoordinates> suzun() {
        ArrayList<GeoCoordinates> suzun = new ArrayList<>();
        suzun.add(new GeoCoordinates(53.833673, 82.327943)); //север
        suzun.add(new GeoCoordinates(53.782585, 82.367768)); //восток
        suzun.add(new GeoCoordinates(53.782585, 82.367768)); //юг
        suzun.add(new GeoCoordinates(53.795971, 82.250352)); //запад
        return suzun;
    }

    private ArrayList<GeoCoordinates> novoaltaysk() {
        ArrayList<GeoCoordinates> novoaltaysk = new ArrayList<>();
        novoaltaysk.add(new GeoCoordinates(53.503662, 83.971401)); //север
        novoaltaysk.add(new GeoCoordinates(53.365809, 84.027706)); //восток
        novoaltaysk.add(new GeoCoordinates(53.361711, 83.902736)); //юг
        novoaltaysk.add(new GeoCoordinates(53.464846, 83.846431)); //запад
        return novoaltaysk;
    }

    private ArrayList<GeoCoordinates> barnaul() {
        ArrayList<GeoCoordinates> barnaul = new ArrayList<>();
        barnaul.add(new GeoCoordinates(53.431044, 83.797691)); //север
        barnaul.add(new GeoCoordinates(53.279409, 83.875282)); //восток
        barnaul.add(new GeoCoordinates(53.261341, 83.690574)); //юг
        barnaul.add(new GeoCoordinates(53.374142, 83.464668)); //запад
        return barnaul;
    }

    private ArrayList<GeoCoordinates> kalmanka() {
        ArrayList<GeoCoordinates> kalmanka = new ArrayList<>();
        kalmanka.add(new GeoCoordinates(52.922873, 83.548667)); //север
        kalmanka.add(new GeoCoordinates(52.905690, 83.578193)); //восток
        kalmanka.add(new GeoCoordinates(52.886843, 83.533561)); //юг
        kalmanka.add(new GeoCoordinates(52.895335, 83.510215)); //запад
        return kalmanka;
    }

    private ArrayList<GeoCoordinates> zarinsk() {
        ArrayList<GeoCoordinates> zarinsk = new ArrayList<>();
        zarinsk.add(new GeoCoordinates(53.787301, 84.937580)); //север
        zarinsk.add(new GeoCoordinates(53.706904, 85.033024)); //восток
        zarinsk.add(new GeoCoordinates(53.668275, 84.938953)); //юг
        zarinsk.add(new GeoCoordinates(53.746716, 84.834583)); //запад
        return zarinsk;
    }

    private ArrayList<GeoCoordinates> biysk() {
        ArrayList<GeoCoordinates> biysk = new ArrayList<>();
        biysk.add(new GeoCoordinates(52.621903, 85.321009)); //север
        biysk.add(new GeoCoordinates(52.538455, 85.392420)); //восток
        biysk.add(new GeoCoordinates(52.420523, 85.021632)); //юг
        biysk.add(new GeoCoordinates(52.558914, 84.944041)); //запад
        return biysk;
    }

    private ArrayList<GeoCoordinates> aleysk() {
        ArrayList<GeoCoordinates> aleysk = new ArrayList<>();
        aleysk.add(new GeoCoordinates(52.530280, 82.807585)); //север
        aleysk.add(new GeoCoordinates(52.489325, 82.856337)); //восток
        aleysk.add(new GeoCoordinates(52.447076, 82.750594)); //юг
        aleysk.add(new GeoCoordinates(52.496432, 82.716261)); //запад
        return aleysk;
    }

    private ArrayList<GeoCoordinates> shipunovo() {
        ArrayList<GeoCoordinates> shipunovo = new ArrayList<>();
        shipunovo.add(new GeoCoordinates(52.279261, 82.259851)); //север
        shipunovo.add(new GeoCoordinates(52.216201, 82.328516)); //восток
        shipunovo.add(new GeoCoordinates(52.189268, 82.251612)); //юг
        shipunovo.add(new GeoCoordinates(52.244799, 82.181574)); //запад
        return shipunovo;
    }

    private ArrayList<GeoCoordinates> belokurikha() {
        ArrayList<GeoCoordinates> belokurikha = new ArrayList<>();
        belokurikha.add(new GeoCoordinates(52.023190, 84.996721)); //север
        belokurikha.add(new GeoCoordinates(51.991701, 85.034659)); //восток
        belokurikha.add(new GeoCoordinates(51.971930, 84.972861)); //юг
        belokurikha.add(new GeoCoordinates(52.001531, 84.932692)); //запад
        return belokurikha;
    }

    private ArrayList<GeoCoordinates> altayskoe() {
        ArrayList<GeoCoordinates> altayskoe = new ArrayList<>();
        altayskoe.add(new GeoCoordinates(52.016002, 85.345463)); //север
        altayskoe.add(new GeoCoordinates(52.007761, 85.383915)); //восток
        altayskoe.add(new GeoCoordinates(51.917642, 85.346149)); //юг
        altayskoe.add(new GeoCoordinates(51.926535, 85.284694)); //запад
        return altayskoe;
    }

    private ArrayList<GeoCoordinates> gornoAltaysk() {
        ArrayList<GeoCoordinates> gornoAltaysk = new ArrayList<>();
        gornoAltaysk.add(new GeoCoordinates(52.005626, 86.014284)); //север
        gornoAltaysk.add(new GeoCoordinates(51.908514, 86.054453)); //восток
        gornoAltaysk.add(new GeoCoordinates(51.907878, 85.947679)); //юг
        gornoAltaysk.add(new GeoCoordinates(51.985544, 85.781168)); //запад
        return gornoAltaysk;
    }

    private ArrayList<GeoCoordinates> pospelikha() {
        ArrayList<GeoCoordinates> pospelikha = new ArrayList<>();
        pospelikha.add(new GeoCoordinates(52.017149, 81.847365)); //север
        pospelikha.add(new GeoCoordinates(51.997917, 81.909335)); //восток
        pospelikha.add(new GeoCoordinates(51.961756, 81.814750)); //юг
        pospelikha.add(new GeoCoordinates(51.989778, 81.777671)); //запад
        return pospelikha;
    }

    private ArrayList<GeoCoordinates> chemal() {
        ArrayList<GeoCoordinates> chemal = new ArrayList<>();
        chemal.add(new GeoCoordinates(51.404312, 86.022329)); //север
        chemal.add(new GeoCoordinates(51.400457, 86.027651)); //восток
        chemal.add(new GeoCoordinates(51.397137, 86.022501)); //юг
        chemal.add(new GeoCoordinates(51.400725, 86.017437)); //запад
        return chemal;
    }

    private ArrayList<GeoCoordinates> rubcovsk() {
        ArrayList<GeoCoordinates> rubcovsk = new ArrayList<>();
        rubcovsk.add(new GeoCoordinates(51.587917, 81.207877)); //север
        rubcovsk.add(new GeoCoordinates(51.526869, 81.349669)); //восток
        rubcovsk.add(new GeoCoordinates(51.451621, 81.269675)); //юг
        rubcovsk.add(new GeoCoordinates(51.498238, 81.099387)); //запад
        return rubcovsk;
    }

    private ArrayList<GeoCoordinates> artybash() {
        ArrayList<GeoCoordinates> artybash = new ArrayList<>();
        artybash.add(new GeoCoordinates(51.801053, 87.267803)); //север
        artybash.add(new GeoCoordinates(51.783268, 87.273296)); //восток
        artybash.add(new GeoCoordinates(51.780082, 87.232183)); //юг
        artybash.add(new GeoCoordinates(51.798186, 87.227892)); //запад
        return artybash;
    }

    private ArrayList<GeoCoordinates> gornyak() {
        ArrayList<GeoCoordinates> gornyak = new ArrayList<>();
        gornyak.add(new GeoCoordinates(51.022174, 81.460318)); //север
        gornyak.add(new GeoCoordinates(50.999169, 81.496024)); //восток
        gornyak.add(new GeoCoordinates(50.977017, 81.474223)); //юг
        gornyak.add(new GeoCoordinates(51.001654, 81.430449)); //запад
        return gornyak;
    }

    private ArrayList<GeoCoordinates> ustKoksa() {
        ArrayList<GeoCoordinates> ustKoksa = new ArrayList<>();
        ustKoksa.add(new GeoCoordinates(50.283873, 85.612294)); //север
        ustKoksa.add(new GeoCoordinates(50.270050, 85.632721)); //восток
        ustKoksa.add(new GeoCoordinates(50.255126, 85.606972)); //юг
        ustKoksa.add(new GeoCoordinates(50.270050, 85.578133)); //запад
        return ustKoksa;
    }

    private ArrayList<GeoCoordinates> promyshlennaya() {
        ArrayList<GeoCoordinates> promyshlennaya = new ArrayList<>();
        promyshlennaya.add(new GeoCoordinates(54.949071, 85.647153)); //север
        promyshlennaya.add(new GeoCoordinates(54.905472, 85.676336)); //восток
        promyshlennaya.add(new GeoCoordinates(54.887012, 85.616254)); //юг
        promyshlennaya.add(new GeoCoordinates(54.938126, 85.589132)); //запад
        return promyshlennaya;
    }

    private ArrayList<GeoCoordinates> leninskKuzneckiy() {
        ArrayList<GeoCoordinates> leninskKuzneckiy = new ArrayList<>();
        leninskKuzneckiy.add(new GeoCoordinates(54.758722, 86.168735)); //север
        leninskKuzneckiy.add(new GeoCoordinates(54.690120, 86.321857)); //восток
        leninskKuzneckiy.add(new GeoCoordinates(54.591972, 86.168735)); //юг
        leninskKuzneckiy.add(new GeoCoordinates(54.661535, 86.054065)); //запад
        return leninskKuzneckiy;
    }

    private ArrayList<GeoCoordinates> belovo() {
        ArrayList<GeoCoordinates> belovo = new ArrayList<>();
        belovo.add(new GeoCoordinates(54.474977, 86.314166)); //север
        belovo.add(new GeoCoordinates(54.422478, 86.379741)); //восток
        belovo.add(new GeoCoordinates(54.388307, 86.276573)); //юг
        belovo.add(new GeoCoordinates(54.425074, 86.222671)); //запад
        return belovo;
    }

    private ArrayList<GeoCoordinates> gurevsk() {
        ArrayList<GeoCoordinates> gurevsk = new ArrayList<>();
        gurevsk.add(new GeoCoordinates(54.317379, 85.986124)); //север
        gurevsk.add(new GeoCoordinates(54.281317, 86.014276)); //восток
        gurevsk.add(new GeoCoordinates(54.246627, 85.851198)); //юг
        gurevsk.add(new GeoCoordinates(54.274101, 85.825448)); //запад
        return gurevsk;
    }

    private ArrayList<GeoCoordinates> kiselevsk() {
        ArrayList<GeoCoordinates> kiselevsk = new ArrayList<>();
        kiselevsk.add(new GeoCoordinates(54.095247, 86.767152)); //север
        kiselevsk.add(new GeoCoordinates(53.979922, 86.852296)); //восток
        kiselevsk.add(new GeoCoordinates(53.910007, 86.547426)); //юг
        kiselevsk.add(new GeoCoordinates(54.021492, 86.458162)); //запад
        return kiselevsk;
    }

    private ArrayList<GeoCoordinates> prokopievsk() {
        ArrayList<GeoCoordinates> prokopievsk = new ArrayList<>();
        prokopievsk.add(new GeoCoordinates(53.988151, 86.740509)); //север
        prokopievsk.add(new GeoCoordinates(53.880625, 86.879898)); //восток
        prokopievsk.add(new GeoCoordinates(53.760645, 86.864105)); //юг
        prokopievsk.add(new GeoCoordinates(53.882648, 86.540695)); //запад
        return prokopievsk;
    }

    private ArrayList<GeoCoordinates> novokuzneck() {
        ArrayList<GeoCoordinates> novokuzneck = new ArrayList<>();
        novokuzneck.add(new GeoCoordinates(53.982808, 87.262539)); //север
        novokuzneck.add(new GeoCoordinates(53.814502, 87.506985)); //восток
        novokuzneck.add(new GeoCoordinates(53.609684, 86.889004)); //юг
        novokuzneck.add(new GeoCoordinates(53.911684, 86.990627)); //запад
        return novokuzneck;
    }

    private ArrayList<GeoCoordinates> osinniki() {
        ArrayList<GeoCoordinates> osinniki = new ArrayList<>();
        osinniki.add(new GeoCoordinates(53.676613, 87.381660)); //север
        osinniki.add(new GeoCoordinates(53.637031, 87.463833)); //восток
        osinniki.add(new GeoCoordinates(53.570212, 87.307278)); //юг
        osinniki.add(new GeoCoordinates(53.651685, 87.255093)); //запад
        return osinniki;
    }

    private ArrayList<GeoCoordinates> mezhdurechensk() {
        ArrayList<GeoCoordinates> mezhdurechensk = new ArrayList<>();
        mezhdurechensk.add(new GeoCoordinates(53.824460, 88.110477)); //север
        mezhdurechensk.add(new GeoCoordinates(53.676671, 88.294498)); //восток
        mezhdurechensk.add(new GeoCoordinates(53.591986, 88.187381)); //юг
        mezhdurechensk.add(new GeoCoordinates(53.785533, 87.745182)); //запад
        return mezhdurechensk;
    }

    private ArrayList<GeoCoordinates> sheregesh() {
        ArrayList<GeoCoordinates> sheregesh = new ArrayList<>();
        sheregesh.add(new GeoCoordinates(52.943496, 87.988255)); //север
        sheregesh.add(new GeoCoordinates(52.919077, 88.030140)); //восток
        sheregesh.add(new GeoCoordinates(52.900442, 87.975208)); //юг
        sheregesh.add(new GeoCoordinates(52.927770, 87.944309)); //запад
        return sheregesh;
    }

    private ArrayList<GeoCoordinates> tashtagol() {
        ArrayList<GeoCoordinates> tashtagol = new ArrayList<>();
        tashtagol.add(new GeoCoordinates(52.797778, 87.947040)); //север
        tashtagol.add(new GeoCoordinates(52.754164, 87.939487)); //восток
        tashtagol.add(new GeoCoordinates(52.745020, 87.835117)); //юг
        tashtagol.add(new GeoCoordinates(52.789474, 87.837177)); //запад
        return tashtagol;
    }

    private ArrayList<GeoCoordinates> turochak() {
        ArrayList<GeoCoordinates> turochak = new ArrayList<>();
        turochak.add(new GeoCoordinates(52.283819, 87.125644)); //север
        turochak.add(new GeoCoordinates(52.265332, 87.186756)); //восток
        turochak.add(new GeoCoordinates(52.220765, 87.135257)); //юг
        turochak.add(new GeoCoordinates(52.251463, 87.081012)); //запад
        return turochak;
    }

    private ArrayList<GeoCoordinates> topki() {
        ArrayList<GeoCoordinates> topki = new ArrayList<>();
        topki.add(new GeoCoordinates(55.328252, 85.586202)); //север
        topki.add(new GeoCoordinates(55.279786, 85.687139)); //восток
        topki.add(new GeoCoordinates(55.244180, 85.607488)); //юг
        topki.add(new GeoCoordinates(55.285261, 85.528524)); //запад
        return topki;
    }

    private ArrayList<GeoCoordinates> kemerovo() {
        ArrayList<GeoCoordinates> kemerovo = new ArrayList<>();
        kemerovo.add(new GeoCoordinates(55.559856, 86.173268)); //север
        kemerovo.add(new GeoCoordinates(55.391740, 86.317463)); //восток
        kemerovo.add(new GeoCoordinates(55.210371, 86.004353)); //юг
        kemerovo.add(new GeoCoordinates(55.439290, 85.847798)); //запад
        return kemerovo;
    }

    private ArrayList<GeoCoordinates> tomsk() {
        ArrayList<GeoCoordinates> tomsk = new ArrayList<>();
        tomsk.add(new GeoCoordinates(56.585243, 85.121234)); //север
        tomsk.add(new GeoCoordinates(56.469736, 85.144580)); //восток
        tomsk.add(new GeoCoordinates(56.393803, 84.970172)); //юг
        tomsk.add(new GeoCoordinates(56.576167, 84.867175)); //запад
        return tomsk;
    }

    private ArrayList<GeoCoordinates> asino() {
        ArrayList<GeoCoordinates> asino = new ArrayList<>();
        asino.add(new GeoCoordinates(57.025868, 86.104628)); //север
        asino.add(new GeoCoordinates(56.995024, 86.232344)); //восток
        asino.add(new GeoCoordinates(56.952735, 86.145827)); //юг
        asino.add(new GeoCoordinates(57.001194, 86.079909)); //запад
        return asino;
    }

    private ArrayList<GeoCoordinates> anzheroSudzhensk() {
        ArrayList<GeoCoordinates> anzheroSudzhensk = new ArrayList<>();
        anzheroSudzhensk.add(new GeoCoordinates(56.167355, 86.030678)); //север
        anzheroSudzhensk.add(new GeoCoordinates(56.095415, 86.162514)); //восток
        anzheroSudzhensk.add(new GeoCoordinates(56.011059, 86.025185)); //юг
        anzheroSudzhensk.add(new GeoCoordinates(56.089286, 85.874123)); //запад
        return anzheroSudzhensk;
    }

    private ArrayList<GeoCoordinates> mariinsk() {
        ArrayList<GeoCoordinates> mariinsk = new ArrayList<>();
        mariinsk.add(new GeoCoordinates(56.289130, 87.784933)); //север
        mariinsk.add(new GeoCoordinates(56.190301, 87.810339)); //восток
        mariinsk.add(new GeoCoordinates(56.135625, 87.702536)); //юг
        mariinsk.add(new GeoCoordinates(56.206726, 87.623572)); //запад
        return mariinsk;
    }

    private ArrayList<GeoCoordinates> tyazhinskiy() {
        ArrayList<GeoCoordinates> tyazhinskiy = new ArrayList<>();
        tyazhinskiy.add(new GeoCoordinates(56.139926, 88.534566)); //север
        tyazhinskiy.add(new GeoCoordinates(56.114094, 88.567868)); //восток
        tyazhinskiy.add(new GeoCoordinates(56.092649, 88.507787)); //юг
        tyazhinskiy.add(new GeoCoordinates(56.116774, 88.461438)); //запад
        return tyazhinskiy;
    }

    private ArrayList<GeoCoordinates> achinsk() {
        ArrayList<GeoCoordinates> achinsk = new ArrayList<>();
        achinsk.add(new GeoCoordinates(56.338188, 90.489492)); //север
        achinsk.add(new GeoCoordinates(56.310013, 90.613088)); //восток
        achinsk.add(new GeoCoordinates(56.173414, 90.475759)); //юг
        achinsk.add(new GeoCoordinates(56.243683, 90.326070)); //запад
        return achinsk;
    }

    private ArrayList<GeoCoordinates> krasnoyarsk() {
        ArrayList<GeoCoordinates> krasnoyarsk = new ArrayList<>();
        krasnoyarsk.add(new GeoCoordinates(56.187469, 93.071721)); //север
        krasnoyarsk.add(new GeoCoordinates(56.000550, 93.233769)); //восток
        krasnoyarsk.add(new GeoCoordinates(55.886730, 92.695439)); //юг
        krasnoyarsk.add(new GeoCoordinates(56.049665, 92.525151)); //запад
        return krasnoyarsk;
    }

    private ArrayList<GeoCoordinates> zheleznogorsk() {
        ArrayList<GeoCoordinates> zheleznogorsk = new ArrayList<>();
        zheleznogorsk.add(new GeoCoordinates(56.292324, 93.547005)); //север
        zheleznogorsk.add(new GeoCoordinates(56.224435, 93.586831)); //восток
        zheleznogorsk.add(new GeoCoordinates(56.207635, 93.441262)); //юг
        zheleznogorsk.add(new GeoCoordinates(56.253436, 93.454995)); //запад
        return zheleznogorsk;
    }

    private ArrayList<GeoCoordinates> zelenogorsk() {
        ArrayList<GeoCoordinates> zelenogorsk = new ArrayList<>();
        zelenogorsk.add(new GeoCoordinates(56.203301, 94.438844)); //север
        zelenogorsk.add(new GeoCoordinates(56.080884, 94.901643)); //восток
        zelenogorsk.add(new GeoCoordinates(56.017226, 94.668183)); //юг
        zelenogorsk.add(new GeoCoordinates(56.090079, 94.383912)); //запад
        return zelenogorsk;
    }

    private ArrayList<GeoCoordinates> abakan() {
        ArrayList<GeoCoordinates> abakan = new ArrayList<>();
        abakan.add(new GeoCoordinates(53.782753, 91.408760)); //север
        abakan.add(new GeoCoordinates(53.706005, 91.627113)); //восток
        abakan.add(new GeoCoordinates(53.611604, 91.533730)); //юг
        abakan.add(new GeoCoordinates(53.721041, 91.237099)); //запад
        return abakan;
    }

    private ArrayList<GeoCoordinates> kansk() {
        ArrayList<GeoCoordinates> kansk = new ArrayList<>();
        kansk.add(new GeoCoordinates(56.265683, 95.781470)); //север
        kansk.add(new GeoCoordinates(56.166411, 95.771857)); //восток
        kansk.add(new GeoCoordinates(56.185904, 95.593329)); //юг
        kansk.add(new GeoCoordinates(56.270640, 95.596763)); //запад
        return kansk;
    }

    private ArrayList<GeoCoordinates> tayshet() {
        ArrayList<GeoCoordinates> tayshet = new ArrayList<>();
        tayshet.add(new GeoCoordinates(55.977596, 97.990943)); //север
        tayshet.add(new GeoCoordinates(55.931465, 98.106299)); //восток
        tayshet.add(new GeoCoordinates(55.889901, 98.012916)); //юг
        tayshet.add(new GeoCoordinates(55.913383, 97.893439)); //запад
        return tayshet;
    }

    private ArrayList<GeoCoordinates> chunskiy() {
        ArrayList<GeoCoordinates> chunskiy = new ArrayList<>();
        chunskiy.add(new GeoCoordinates(56.119662, 99.645886)); //север
        chunskiy.add(new GeoCoordinates(56.092092, 99.709744)); //восток
        chunskiy.add(new GeoCoordinates(56.062394, 99.678502)); //юг
        chunskiy.add(new GeoCoordinates(56.087495, 99.586148)); //запад
        return chunskiy;
    }

    private ArrayList<GeoCoordinates> nizhneudinsk() {
        ArrayList<GeoCoordinates> nizhneudinsk = new ArrayList<>();
        nizhneudinsk.add(new GeoCoordinates(54.962149, 99.031795)); //север
        nizhneudinsk.add(new GeoCoordinates(54.918368, 99.112819)); //восток
        nizhneudinsk.add(new GeoCoordinates(54.863080, 99.066127)); //юг
        nizhneudinsk.add(new GeoCoordinates(54.908500, 98.934978)); //запад
        return nizhneudinsk;
    }

    private ArrayList<GeoCoordinates> irkutsk() {
        ArrayList<GeoCoordinates> irkutsk = new ArrayList<>();
        irkutsk.add(new GeoCoordinates(52.444143, 104.135315)); //север
        irkutsk.add(new GeoCoordinates(52.323441, 104.489624)); //восток
        irkutsk.add(new GeoCoordinates(52.183887, 104.316589)); //юг
        irkutsk.add(new GeoCoordinates(52.274731, 104.066650)); //запад
        return irkutsk;
    }

    Map<ArrayList<GeoCoordinates>,Integer> setFixKmArr() {
        Map<ArrayList<GeoCoordinates>,Integer> fixKmArr = new HashMap<>();
        fixKmArr.put(kochenevo(),120);
        fixKmArr.put(duplenskaya(),180);
        fixKmArr.put(kabinetnoe(),240);
        fixKmArr.put(chulym(),300);
        fixKmArr.put(kokosheno(),320);
        fixKmArr.put(kargat(),400);
        fixKmArr.put(ubinskoe(),460);
        fixKmArr.put(dovolnoe(),600);
        fixKmArr.put(barabinsk(),660);
        fixKmArr.put(kuibyshev(),700);
        fixKmArr.put(chany(),860);
        fixKmArr.put(bagan(),900);
        fixKmArr.put(vengerovo(),950);
        fixKmArr.put(tatarsk(),960);
        fixKmArr.put(kupino(),1000);
        fixKmArr.put(chistoozernoe(),1100);
        fixKmArr.put(omsk(),1350);
        fixKmArr.put(ishim(),2000);
        fixKmArr.put(tumen(),2600);
        fixKmArr.put(kurgan(),2800);
        fixKmArr.put(chelyabinsk(),3200);
        fixKmArr.put(ekaterinburg(),3200);
        fixKmArr.put(verkhIrmen(),160);
        fixKmArr.put(krasnyiYar(),180);
        fixKmArr.put(ordynskoe(),220);
        fixKmArr.put(spirino(),300);
        fixKmArr.put(proletarskiy(),320);
        fixKmArr.put(krutikha(),360);
        fixKmArr.put(bystrukha(),360);
        fixKmArr.put(zhulanka(),400);
        fixKmArr.put(kamenNaObi(),400);
        fixKmArr.put(kochki(),420);
        fixKmArr.put(pankrushikha(),500);
        fixKmArr.put(baevo(),600);
        fixKmArr.put(krasnozerskoe(),600);
        fixKmArr.put(khabary(),600);
        fixKmArr.put(zavyalovo(),700);
        fixKmArr.put(golbshtadt(),750);
        fixKmArr.put(romanovo(),760);
        fixKmArr.put(karasuk(),800);
        fixKmArr.put(slavgorod(),800);
        fixKmArr.put(yarovoe(),820);
        fixKmArr.put(mamontovo(),850);
        fixKmArr.put(blagoveshenka(),850);
        fixKmArr.put(tabuny(),900);
        fixKmArr.put(rodino(),920);
        fixKmArr.put(kulunda(),950);
        fixKmArr.put(iskitim(),130);
        fixKmArr.put(linevo(),160);
        fixKmArr.put(dorogino(),190);
        fixKmArr.put(medvedskoe(),200);
        fixKmArr.put(cherepanovo(),220);
        fixKmArr.put(bezmenovo(),250);
        fixKmArr.put(talmenka(),330);
        fixKmArr.put(maslyanino(),360);
        fixKmArr.put(sibirskiy(),400);
        fixKmArr.put(suzun(),400);
        fixKmArr.put(novoaltaysk(),450);
        fixKmArr.put(barnaul(),500);
        fixKmArr.put(kalmanka(),600);
        fixKmArr.put(zarinsk(),600);
        fixKmArr.put(biysk(),750);
        fixKmArr.put(aleysk(),750);
        fixKmArr.put(shipunovo(),850);
        fixKmArr.put(belokurikha(),860);
        fixKmArr.put(altayskoe(),900);
        fixKmArr.put(gornoAltaysk(),950);
        fixKmArr.put(pospelikha(),920);
        fixKmArr.put(chemal(),1100);
        fixKmArr.put(rubcovsk(),1100);
        fixKmArr.put(artybash(),1260);
        fixKmArr.put(gornyak(),1300);
        fixKmArr.put(ustKoksa(),1700);
        fixKmArr.put(karpysak(),130);
        fixKmArr.put(gornyi(),150);
        fixKmArr.put(ustKamenka(),150);
        fixKmArr.put(vladimirovka(),170);
        fixKmArr.put(lebedevo(),220);
        fixKmArr.put(toguchin(),240);
        fixKmArr.put(zhuravlevo(),320);
        fixKmArr.put(vaganovo(),360);
        fixKmArr.put(krasnoe(),380);
        fixKmArr.put(promyshlennaya(),420);
        fixKmArr.put(leninskKuzneckiy(),500);
        fixKmArr.put(belovo(),600);
        fixKmArr.put(gurevsk(),600);
        fixKmArr.put(kiselevsk(),700);
        fixKmArr.put(prokopievsk(),720);
        fixKmArr.put(novokuzneck(),800);
        fixKmArr.put(osinniki(),800);
        fixKmArr.put(mezhdurechensk(),1000);
        fixKmArr.put(sheregesh(),1100);
        fixKmArr.put(tashtagol(),1130);
        fixKmArr.put(turochak(),1300);
        fixKmArr.put(kolyvan(),100);
        fixKmArr.put(moshkovo(),130);
        fixKmArr.put(stancionnoOyashinskiy(),190);
        fixKmArr.put(tashara(),220);
        fixKmArr.put(bolotnoe(),280);
        fixKmArr.put(pikhtovka(),280);
        fixKmArr.put(bazoy(),280);
        fixKmArr.put(urga(),380);
        fixKmArr.put(kozhevnikovo(),400);
        fixKmArr.put(topki(),500);
        fixKmArr.put(kemerovo(),600);
        fixKmArr.put(tomsk(),600);
        fixKmArr.put(asino(),800);
        fixKmArr.put(anzheroSudzhensk(),800);
        fixKmArr.put(mariinsk(),900);
        fixKmArr.put(tyazhinskiy(),1000);
        fixKmArr.put(achinsk(),1300);
        fixKmArr.put(krasnoyarsk(),1650);
        fixKmArr.put(zheleznogorsk(),1750);
        fixKmArr.put(zelenogorsk(),1950);
        fixKmArr.put(abakan(),2200);
        fixKmArr.put(kansk(),2000);
        fixKmArr.put(tayshet(),2400);
        fixKmArr.put(chunskiy(),2600);
        fixKmArr.put(nizhneudinsk(),2600);
        fixKmArr.put(irkutsk(),3900);

        return fixKmArr;
    }

    ArrayList<MapPolygon> arrayMapPolygon(){
        ArrayList<MapPolygon> arrayMapPolygon = new ArrayList<>();
        for (ArrayList<GeoCoordinates> gc : setFixKmArr().keySet()){
            GeoPolygon geoPolygon;
            try {
                geoPolygon = new GeoPolygon(gc);
            } catch (InstantiationErrorException e) {
                return null;
            }
            MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
            //mapPolygonStyle.setStrokeColor(0xff000000, PixelFormat.ARGB_8888);
            MapPolygon mapPolygon = new MapPolygon(geoPolygon, mapPolygonStyle);
            arrayMapPolygon.add(mapPolygon);
        }
        return arrayMapPolygon;
    }
}
