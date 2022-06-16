package com.example.heretest;

import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoPolygon;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.mapviewlite.MapPolygon;
import com.here.sdk.mapviewlite.MapPolygonStyle;
import com.here.sdk.mapviewlite.PixelFormat;

import java.util.ArrayList;
import java.util.List;

class HoursNSK {
    private final long STROKE_COLOR = 0x00000000;
    ArrayList<GeoCoordinates> arrHour00 = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour05l = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour05r = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour10l = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour10r = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour15l = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour15r = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour20l = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour20r = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour25l = new ArrayList<>();
    ArrayList<GeoCoordinates> arrHour25r = new ArrayList<>();

    MapPolygon hour00() {

        arrHour00.add(new GeoCoordinates(54.933332, 82.813875)); //выезд на ордынку
        arrHour00.add(new GeoCoordinates(54.964867, 82.816803)); //остановка Склады толмачевское шоссе
        arrHour00.add(new GeoCoordinates(54.996664, 82.750670)); //экспоцентр остановка
        arrHour00.add(new GeoCoordinates(55.021165, 82.813716)); // дивногорский
        arrHour00.add(new GeoCoordinates(55.020124, 82.861087)); //затон
        arrHour00.add(new GeoCoordinates(55.032271, 82.869085)); //затон обь
        arrHour00.add(new GeoCoordinates(55.058400, 82.815327)); //заельцовский бор обь
        arrHour00.add(new GeoCoordinates(55.103100, 82.899268)); //карьер мочище
        arrHour00.add(new GeoCoordinates(55.120750, 82.926818)); //фудсиб
        arrHour00.add(new GeoCoordinates(55.118514, 82.973217)); //садовый
        arrHour00.add(new GeoCoordinates(55.107116, 82.999331)); //пашинский переезд
        //arrHour00.add(new GeoCoordinates(55.078783, 83.034274)); //восход поселок
        arrHour00.add(new GeoCoordinates(55.071562, 83.008197)); //Золотая Горка(Женя)
        arrHour00.add(new GeoCoordinates(55.048291, 83.071036)); //зеленодолинская остановка гусинка
        arrHour00.add(new GeoCoordinates(55.009839, 83.049661)); //выборная ТЭЦ
        arrHour00.add(new GeoCoordinates(54.988866, 83.052411)); //выборная со стороны планетария
        arrHour00.add(new GeoCoordinates(54.975568, 83.033512)); //разъезд иня
        arrHour00.add(new GeoCoordinates(54.961237, 82.988807)); //Обь у ЖД моста
        arrHour00.add(new GeoCoordinates(54.939549, 82.990180)); //белые росы
        arrHour00.add(new GeoCoordinates(54.926035, 82.948300)); //Элитный поселок
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour00);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x2081C784, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour05l() {

        arrHour05l.add(new GeoCoordinates(54.898916, 82.989170)); //Юный Ленинец
        arrHour05l.add(new GeoCoordinates(54.901661, 82.826933)); //учхоз
        arrHour05l.add(new GeoCoordinates(54.909411, 82.797495)); //верх-тула
        arrHour05l.add(new GeoCoordinates(54.984300, 82.757436)); //с Толмачево
        arrHour05l.add(new GeoCoordinates(54.995127, 82.731423)); //г Обь
        arrHour05l.add(new GeoCoordinates(55.040962, 82.774975)); //Марусино
        arrHour05l.add(new GeoCoordinates(55.064464, 82.781931)); //Приобский
        arrHour05l.add(new GeoCoordinates(55.074383, 82.797638)); //Приобский Обь

        arrHour05l.add(new GeoCoordinates(55.058400, 82.815327)); //заельцовский бор обь
        arrHour05l.add(new GeoCoordinates(55.032271, 82.869085)); //затон обь
        arrHour05l.add(new GeoCoordinates(55.020124, 82.861087)); //затон
        arrHour05l.add(new GeoCoordinates(55.021165, 82.813716)); // дивногорский
        arrHour05l.add(new GeoCoordinates(54.996664, 82.750670)); //экспоцентр остановка
        arrHour05l.add(new GeoCoordinates(54.964867, 82.816803)); //остановка Склады толмачевское шоссе
        arrHour05l.add(new GeoCoordinates(54.933332, 82.813875)); //выезд на ордынку
        arrHour05l.add(new GeoCoordinates(54.926035, 82.948300)); //Элитный поселок
        arrHour05l.add(new GeoCoordinates(54.939549, 82.990180)); //белые росы
        arrHour05l.add(new GeoCoordinates(54.961237, 82.988807)); //Обь у ЖД моста
        arrHour05l.add(new GeoCoordinates(54.940948, 83.044462)); //Обьские зори Обь
        arrHour05l.add(new GeoCoordinates(54.918459, 83.047037)); //Тихие зори Обь
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour05l);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x20ffff00, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour05r() {

        arrHour05r.add(new GeoCoordinates(55.074383, 82.797638)); //Приобский Обь
        arrHour05r.add(new GeoCoordinates(55.137035, 82.866303)); //мочище сп
        arrHour05r.add(new GeoCoordinates(55.131231, 82.960563)); //Садовый
        arrHour05r.add(new GeoCoordinates(55.141316, 83.077654)); //Мочище СТ
        arrHour05r.add(new GeoCoordinates(55.056615, 83.108176)); //Раздольное
        arrHour05r.add(new GeoCoordinates(54.954302, 83.159127)); //Барышево
        arrHour05r.add(new GeoCoordinates(54.927338, 83.076048)); //Матвеевка
        arrHour05r.add(new GeoCoordinates(54.918459, 83.047037)); //Тихие зори Обь
        arrHour05r.add(new GeoCoordinates(54.940948, 83.044462)); //Обьские зори Обь

        arrHour05r.add(new GeoCoordinates(54.961237, 82.988807)); //Обь у ЖД моста
        arrHour05r.add(new GeoCoordinates(54.975568, 83.033512)); //разъезд иня
        arrHour05r.add(new GeoCoordinates(54.988866, 83.052411)); //выборная со стороны планетария
        arrHour05r.add(new GeoCoordinates(55.009839, 83.049661)); //выборная ТЭЦ
        arrHour05r.add(new GeoCoordinates(55.048291, 83.071036)); //зеленодолинская остановка гусинка
        //arrHour05r.add(new GeoCoordinates(55.078783, 83.034274)); //восход поселок
        arrHour05r.add(new GeoCoordinates(55.071562, 83.008197)); //Золотая Горка(Женя)
        arrHour05r.add(new GeoCoordinates(55.107116, 82.999331)); //пашинский переезд
        arrHour05r.add(new GeoCoordinates(55.118514, 82.973217)); //садовый
        arrHour05r.add(new GeoCoordinates(55.120750, 82.926818)); //фудсиб
        arrHour05r.add(new GeoCoordinates(55.103100, 82.899268)); //карьер мочище
        arrHour05r.add(new GeoCoordinates(55.058400, 82.815327)); //заельцовский бор обь
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour05r);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x20ffff00, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour10l() {

        arrHour10l.add(new GeoCoordinates(54.823260, 82.968632)); //ОбьГЭС Обское водохранилище
        arrHour10l.add(new GeoCoordinates(54.837658, 82.921374)); //Голубой залив
        arrHour10l.add(new GeoCoordinates(54.852827, 82.725917)); //п Крупской
        arrHour10l.add(new GeoCoordinates(54.973215, 82.666353)); //Павино
        arrHour10l.add(new GeoCoordinates(55.001028, 82.630970)); //Павино омский тракт
        arrHour10l.add(new GeoCoordinates(55.086587, 82.621449)); //за Криводановкой
        arrHour10l.add(new GeoCoordinates(55.114732, 82.792211)); //за Кудряшевским Обь

        arrHour10l.add(new GeoCoordinates(55.074383, 82.797638)); //Приобский Обь
        arrHour10l.add(new GeoCoordinates(55.064464, 82.781931)); //Приобский
        arrHour10l.add(new GeoCoordinates(55.040962, 82.774975)); //Марусино
        arrHour10l.add(new GeoCoordinates(54.995127, 82.731423)); //г Обь
        arrHour10l.add(new GeoCoordinates(54.984300, 82.757436)); //с Толмачево
        arrHour10l.add(new GeoCoordinates(54.909411, 82.797495)); //верх-тула
        arrHour10l.add(new GeoCoordinates(54.901661, 82.826933)); //учхоз
        arrHour10l.add(new GeoCoordinates(54.898916, 82.989170)); //Юный Ленинец
        arrHour10l.add(new GeoCoordinates(54.918459, 83.047037)); //Тихие зори Обь
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour10l);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x20F9A825, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour10r() {

        arrHour10r.add(new GeoCoordinates(55.114732, 82.792211)); //за Кудряшевским Обь
        arrHour10r.add(new GeoCoordinates(55.215486, 82.905836)); //Красный яр
        arrHour10r.add(new GeoCoordinates(55.163984, 83.153533)); //Октябрьский за мочище
        arrHour10r.add(new GeoCoordinates(55.139571, 83.099881)); //Витаминка
        arrHour10r.add(new GeoCoordinates(55.062392, 83.215658)); //Гусиный Брод
        arrHour10r.add(new GeoCoordinates(54.969101, 83.202583)); //За барышево
        arrHour10r.add(new GeoCoordinates(54.941728, 83.217290)); //Кольцово пополам
        arrHour10r.add(new GeoCoordinates(54.842779, 83.123214)); //БотСад
        arrHour10r.add(new GeoCoordinates(54.824051, 83.088108)); //за Академом
        arrHour10r.add(new GeoCoordinates(54.823260, 82.968632)); //ОбьГЭС Обское водохранилище

        arrHour10r.add(new GeoCoordinates(54.918459, 83.047037)); //Тихие зори Обь
        arrHour10r.add(new GeoCoordinates(54.927338, 83.076048)); //Матвеевка
        arrHour10r.add(new GeoCoordinates(54.954302, 83.159127)); //Барышево
        arrHour10r.add(new GeoCoordinates(55.056615, 83.108176)); //Раздольное
        arrHour10r.add(new GeoCoordinates(55.141316, 83.077654)); //Мочище СТ
        arrHour10r.add(new GeoCoordinates(55.131231, 82.960563)); //Садовый
        arrHour10r.add(new GeoCoordinates(55.137035, 82.866303)); //мочище сп
        arrHour10r.add(new GeoCoordinates(55.074383, 82.797638)); //Приобский Обь
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour10r);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x20F9A825, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour15l() {

        arrHour15l.add(new GeoCoordinates(54.803784, 82.924132)); //Обь сЛенинское
        arrHour15l.add(new GeoCoordinates(54.816035, 82.632523)); //Ярково
        arrHour15l.add(new GeoCoordinates(54.944526, 82.631611)); //Алексеевка
        arrHour15l.add(new GeoCoordinates(55.018176, 82.485394)); //Прокудское
        arrHour15l.add(new GeoCoordinates(55.113293, 82.561253)); //Катково
        arrHour15l.add(new GeoCoordinates(55.138187, 82.813270)); //СНТ Энергоноситель Обь

        arrHour15l.add(new GeoCoordinates(55.114732, 82.792211)); //за Кудряшевским Обь
        arrHour15l.add(new GeoCoordinates(55.086587, 82.621449)); //за Криводановкой
        arrHour15l.add(new GeoCoordinates(55.001028, 82.630970)); //Павино омский тракт
        arrHour15l.add(new GeoCoordinates(54.973215, 82.666353)); //Павино
        arrHour15l.add(new GeoCoordinates(54.852827, 82.725917)); //п Крупской
        arrHour15l.add(new GeoCoordinates(54.837658, 82.921374)); //Голубой залив
        arrHour15l.add(new GeoCoordinates(54.823260, 82.968632)); //ОбьГЭС Обское водохранилище
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour15l);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x20ff0000, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour15r() {

        arrHour15r.add(new GeoCoordinates(55.138187, 82.813270)); //СНТ Энергоноситель Обь
        arrHour15r.add(new GeoCoordinates(55.192117, 82.875411)); //Мост северный объезд!
        arrHour15r.add(new GeoCoordinates(55.256384, 82.923885)); //Кубовая с
        arrHour15r.add(new GeoCoordinates(55.199028, 83.218613)); //Барлак
        arrHour15r.add(new GeoCoordinates(55.143031, 83.189754)); //за с Новокаменка
        arrHour15r.add(new GeoCoordinates(55.132139, 83.121938)); //днт Раздолье
        arrHour15r.add(new GeoCoordinates(55.067835, 83.311551)); // за гусиным бродом
        arrHour15r.add(new GeoCoordinates(54.966873, 83.301559)); //Шелковичиха
        arrHour15r.add(new GeoCoordinates(54.854092, 83.189077)); //Ложок
        arrHour15r.add(new GeoCoordinates(54.784706, 83.152074)); //ул Таежная Бердск
        arrHour15r.add(new GeoCoordinates(54.793584, 83.080106)); //Бердское шоссе перед Бердском
        arrHour15r.add(new GeoCoordinates(54.803784, 83.064208)); //Бердь
        arrHour15r.add(new GeoCoordinates(54.803784, 82.924132)); //Обь сЛенинское

        arrHour15r.add(new GeoCoordinates(54.823260, 82.968632)); //ОбьГЭС Обское водохранилище
        arrHour15r.add(new GeoCoordinates(54.824051, 83.088108)); //за Академом
        arrHour15r.add(new GeoCoordinates(54.842779, 83.123214)); //БотСад
        arrHour15r.add(new GeoCoordinates(54.941728, 83.217290)); //Кольцово пополам
        arrHour15r.add(new GeoCoordinates(54.969101, 83.202583)); //За барышево
        arrHour15r.add(new GeoCoordinates(55.062392, 83.215658)); //Гусиный Брод
        arrHour15r.add(new GeoCoordinates(55.139571, 83.099881)); //Витаминка
        arrHour15r.add(new GeoCoordinates(55.163984, 83.153533)); //Октябрьский за мочище
        arrHour15r.add(new GeoCoordinates(55.215486, 82.905836)); //Красный яр
        arrHour15r.add(new GeoCoordinates(55.114732, 82.792211)); //за Кудряшевским Обь
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour15r);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x20ff0000, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour20l() {

        arrHour20l.add(new GeoCoordinates(54.723400, 82.835442)); //Обь Боровое!
        arrHour20l.add(new GeoCoordinates(54.752741, 82.521342)); //поворот на Боровое
        arrHour20l.add(new GeoCoordinates(55.042008, 82.319329)); //Коченево
        arrHour20l.add(new GeoCoordinates(55.137284, 82.554488)); //Крохалевка
        arrHour20l.add(new GeoCoordinates(55.284902, 82.716749)); //Колывань
        arrHour20l.add(new GeoCoordinates(55.304254, 82.875364)); //Обь Зеленый мыс!
        arrHour20l.add(new GeoCoordinates(55.263848, 82.854742)); //Обь за сКубовая

        arrHour20l.add(new GeoCoordinates(55.192117, 82.875411)); //Мост северный объезд!
        arrHour20l.add(new GeoCoordinates(55.138187, 82.813270)); //СНТ Энергоноситель Обь
        arrHour20l.add(new GeoCoordinates(55.113293, 82.561253)); //Катково
        arrHour20l.add(new GeoCoordinates(55.018176, 82.485394)); //Прокудское
        arrHour20l.add(new GeoCoordinates(55.018176, 82.485394)); //Прокудское
        arrHour20l.add(new GeoCoordinates(54.944526, 82.631611)); //Алексеевка
        arrHour20l.add(new GeoCoordinates(54.816035, 82.632523)); //Ярково
        arrHour20l.add(new GeoCoordinates(54.803784, 82.924132)); //Обь сЛенинское
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour20l);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x208b00ff, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour20r() {

        arrHour20r.add(new GeoCoordinates(55.263848, 82.854742)); //Обь за сКубовая
        arrHour20r.add(new GeoCoordinates(55.304254, 82.875364)); //Обь Зеленый мыс!
        arrHour20r.add(new GeoCoordinates(55.322492, 82.889074)); //Бибиха
        arrHour20r.add(new GeoCoordinates(55.229763, 83.347038)); //Емельяновский
        arrHour20r.add(new GeoCoordinates(55.051853, 83.445476)); //Репьево
        arrHour20r.add(new GeoCoordinates(55.025284, 83.542510)); //за Плотниково
        arrHour20r.add(new GeoCoordinates(54.686107, 83.207604)); //Лебедевка
        arrHour20r.add(new GeoCoordinates(54.723400, 82.835442)); //Обь Боровое!

        arrHour20r.add(new GeoCoordinates(54.803784, 82.924132)); //Обь сЛенинское
        arrHour20r.add(new GeoCoordinates(54.803784, 83.064208)); //Бердь
        arrHour20r.add(new GeoCoordinates(54.793584, 83.080106)); //Бердское шоссе перед Бердском
        arrHour20r.add(new GeoCoordinates(54.784706, 83.152074)); //ул Таежная Бердск
        arrHour20r.add(new GeoCoordinates(54.854092, 83.189077)); //Ложок
        arrHour20r.add(new GeoCoordinates(54.966873, 83.301559)); //Шелковичиха
        arrHour20r.add(new GeoCoordinates(55.067835, 83.311551)); // за гусиным бродом
        arrHour20r.add(new GeoCoordinates(55.132139, 83.121938)); //днт Раздолье
        arrHour20r.add(new GeoCoordinates(55.143031, 83.189754)); //за с Новокаменка
        arrHour20r.add(new GeoCoordinates(55.199028, 83.218613)); //Барлак
        arrHour20r.add(new GeoCoordinates(55.256384, 82.923885)); //Кубовая с
        arrHour20r.add(new GeoCoordinates(55.192117, 82.875411)); //Мост северный объезд!
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour20r);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x208b00ff, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour25l() {

        arrHour25l.add(new GeoCoordinates(54.585110, 82.518495)); //Обь Новопичугово!
        arrHour25l.add(new GeoCoordinates(54.603164, 82.303042)); //ВерхИрмень
        arrHour25l.add(new GeoCoordinates(55.079760, 81.985960)); //Лесная поляна
        arrHour25l.add(new GeoCoordinates(55.495499, 82.758542)); //Вьюны

        arrHour25l.add(new GeoCoordinates(55.497085, 83.339290)); //Обь Дубровино!
        arrHour25l.add(new GeoCoordinates(55.429349, 83.144282)); //Обь Белоярка
        arrHour25l.add(new GeoCoordinates(55.442983, 82.928675)); //Обь Юрт-Ора
        arrHour25l.add(new GeoCoordinates(55.384517, 82.809885)); //Обь Скала

        arrHour25l.add(new GeoCoordinates(55.304254, 82.875364)); //Обь Зеленый мыс!
        arrHour25l.add(new GeoCoordinates(55.284902, 82.716749)); //Колывань
        arrHour25l.add(new GeoCoordinates(55.137284, 82.554488)); //Крохалевка
        arrHour25l.add(new GeoCoordinates(55.042008, 82.319329)); //Коченево
        arrHour25l.add(new GeoCoordinates(54.752741, 82.521342)); //поворот на Боровое
        arrHour25l.add(new GeoCoordinates(54.723400, 82.835442)); //Обь Боровое
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour25l);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x2000BFFF, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    MapPolygon hour25r() {

        arrHour25r.add(new GeoCoordinates(55.384517, 82.809885)); //Обь Скала
        arrHour25r.add(new GeoCoordinates(55.442983, 82.928675)); //Обь Юрт-Ора
        arrHour25r.add(new GeoCoordinates(55.429349, 83.144282)); //Обь Белоярка
        arrHour25r.add(new GeoCoordinates(55.497085, 83.339290)); //Обь Дубровино!

        arrHour25r.add(new GeoCoordinates(55.476854, 83.792476)); //СтанционноОяшенский
        arrHour25r.add(new GeoCoordinates(55.113966, 83.835581)); //Горный
        arrHour25r.add(new GeoCoordinates(54.974014, 83.917674)); //за Устькаменкой
        arrHour25r.add(new GeoCoordinates(54.534943, 83.331483)); //Евсино
        arrHour25r.add(new GeoCoordinates(54.585110, 82.518495)); //Обь Новопичугово!

        arrHour25r.add(new GeoCoordinates(54.723400, 82.835442)); //Обь Боровое!
        arrHour25r.add(new GeoCoordinates(54.686107, 83.207604)); //Лебедевка
        arrHour25r.add(new GeoCoordinates(55.025284, 83.542510)); //за Плотниково
        arrHour25r.add(new GeoCoordinates(55.051853, 83.445476)); //Репьево
        arrHour25r.add(new GeoCoordinates(55.229763, 83.347038)); //Емельяновский
        arrHour25r.add(new GeoCoordinates(55.322492, 82.889074)); //Бибиха
        arrHour25r.add(new GeoCoordinates(55.304254, 82.875364)); //Обь Зеленый мыс!
        GeoPolygon geoPolygon;
        try {
            geoPolygon = new GeoPolygon(arrHour25r);
        } catch (InstantiationErrorException e) {
            // Less than three vertices.
            return null;
        }
        MapPolygonStyle mapPolygonStyle = new MapPolygonStyle();
        mapPolygonStyle.setFillColor(0x2000BFFF, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeColor(STROKE_COLOR, PixelFormat.ARGB_8888);
        mapPolygonStyle.setStrokeWidth(1);
        return new MapPolygon(geoPolygon, mapPolygonStyle);
    }

    List<GeoCoordinates> allHours() {
        List<GeoCoordinates> allHours = new ArrayList<>();
        allHours.add(new GeoCoordinates(54.603164, 82.303042)); //ВерхИрмень
        allHours.add(new GeoCoordinates(55.079760, 81.985960)); //Лесная поляна
        allHours.add(new GeoCoordinates(55.495499, 82.758542)); //Вьюны
        allHours.add(new GeoCoordinates(55.476854, 83.792476)); //СтанционноОяшенский
        allHours.add(new GeoCoordinates(55.113966, 83.835581)); //Горный
        allHours.add(new GeoCoordinates(54.974014, 83.917674)); //за Устькаменкой
        allHours.add(new GeoCoordinates(54.534943, 83.331483)); //Евсино

        return allHours;
    }
}
