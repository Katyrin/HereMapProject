package com.example.heretest;

class Truck {
    //Прайс для VS
    static int km25 = 0;
    private static int km;
    private static int min;
    private static int price;
    static int nightPrice;
    static int coldPrice;
    static int coldKm25;
    static int coldKm;
    static int apparelPrice;
    static int apparelKm25;
    static int apparelKm;

    String countStr(double coefficient) {
        if (coefficient == 0) {
            return "\n" + min + " часа, умнажаем на " + (price + coldPrice + nightPrice + apparelPrice) + " руб/ч.";
        } else {
            return "\n" + min + " часа + " + coefficient + " часа отдаления, умнажаем на " +
                    (price + coldPrice + nightPrice + apparelPrice) + " руб/ч.";
        }
    }

    double count(double coefficient) {
        return (min + coefficient) * (price + coldPrice + nightPrice + apparelPrice);
    }

    String countSecondStr(double coefficient) {
        return "\nИ " + coefficient + " часа отдаления, умнажаем на " +
                (price + coldPrice + nightPrice + apparelPrice) + " руб/ч.";
    }

    Double countSecond(double coefficient) {
        return coefficient * (price + coldPrice + nightPrice + apparelPrice);
    }

    String count25Str(double coefficient, double routePrice) {
        if (km25 == 0) {
            if (coefficient == 0) {
                return "\n" + min + " часа, умнажаем на " + (price + coldPrice + nightPrice + apparelPrice) + " руб/ч.";
            } else {
                return "\n" + min + " часа + " + coefficient + " часа отдаления, умнажаем на " +
                        (price + coldPrice + nightPrice + apparelPrice) + " руб/ч.";
            }
        } else {
            return "\n" + min + " часа, умнажаем на " + (price + coldPrice + nightPrice + apparelPrice) +
                    " руб/ч. плюс " + (km25 + coldKm25 + apparelKm25) + " р/км умноженное на " + routePrice + " км.";
        }
    }

    Double count25(double coefficient, double routePrice) {
        if (km25 == 0) {
            return (min + coefficient) * (price + coldPrice + nightPrice + apparelPrice);
        } else {
            return min * (price + coldPrice + nightPrice + apparelPrice) + (km25 + coldKm25 + apparelKm25) * routePrice;
        }
    }

    String count25SecondStr(double coefficient, double routePrice) {
        if (km25 == 0) {
            return "\nИ " + coefficient + " часа отдаления, умнажаем на " +
                    (price + coldPrice + nightPrice + apparelPrice) + " руб/ч.";
        } else {
            return "\nПлюс " + routePrice + " км. умноженное на " + (km25 + coldKm25 + apparelKm25) + " р/км";
        }
    }

    Double count25Second(double coefficient, double routePrice) {
        if (km25 == 0) {
            return coefficient * (price + coldPrice + nightPrice + apparelPrice);
        } else {
            return (km25 + coldKm25 + apparelKm25) * routePrice;
        }
    }

    String count150KmStr(double routePrice) {
        return "\n" + min + " часа, умнажаем на " + (price + coldPrice + nightPrice + apparelPrice) +
                " руб/ч. плюс " + (km + coldKm + apparelKm) + " р/км умноженное на " + routePrice + " км.";
    }

    Double count150Km(double routePrice) {
        return min * (price + coldPrice + nightPrice + apparelPrice) + (km + coldKm + apparelKm) * routePrice;
    }

    String count150KmSecondStr(double routePrice) {
        return "\nПлюс " + routePrice + " км. умноженное на " + (km + coldKm + apparelKm) + " р/км";
    }

    Double count150KmSecond(double routePrice) {
        return (km + coldKm + apparelKm) * routePrice;
    }

    String count200KmStr(double routePrice) {
        if (km25 == 0) {
            return "\n" + 2.5 + " часа, умнажаем на " + (price + coldPrice + nightPrice + apparelPrice) +
                    " руб/ч. плюс " + (km + coldKm + apparelKm) + " р/км умноженное на " + routePrice + " км.";
        } else {
            return "\n" + 1 + " час, умнажаем на " + (price + coldPrice + nightPrice + apparelPrice) +
                    " руб/ч. плюс " + (km + coldKm + apparelKm) + " р/км умноженное на " + routePrice + " км.";
        }
    }

    Double count200Km(double routePrice) {
        if (km25 == 0) {
            return 2.5 * (price + coldPrice + nightPrice + apparelPrice) + (km + coldKm + apparelKm) * routePrice;
        } else {
            return (price + coldPrice + nightPrice + apparelPrice) + (km + coldKm + apparelKm) * routePrice;
        }
    }

    String countAllKmStr(double routePrice) {
        return "\n" + routePrice + " км. умноженное на " + (km + coldKm + apparelKm) + " р/км";
    }

    Double countAllKm(double routePrice) {
        return (km + coldKm + apparelKm) * routePrice;
    }

    void onClickGazelleTent() {
        km25 = 20;
        km = 20;
        min = 2;
        price = 700;
    }

    void onClickGazelleThermos() {
        km25 = 20;
        km = 20;
        min = 2;
        price = 700;
    }

    void onClickGazelleHeight() {
        km25 = 21;
        km = 21;
        min = 2;
        price = 800;
    }

    void onClickGazelleBoard() {
        km25 = 21;
        km = 21;
        min = 2;
        price = 850;
    }

    void onClickGazelleFarmer() {
        km25 = 21;
        km = 21;
        min = 2;
        price = 800;
    }

    void onClickGazelleRef() {
        km25 = 22;
        km = 22;
        min = 3;
        price = 800;
    }

    void onClickGazellePyramid() {
        km25 = 23;
        km = 23;
        min = 3;
        price = 900;
    }

    void onClickGazelleTrowing() {
        km25 = 22;
        km = 22;
        min = 2;
        price = 800;
    }

    void onClickGazelleLongOriginal() {
        km25 = 21;
        km = 21;
        min = 2;
        price = 800;
    }

    void onClickGazelleLongBoard() {
        km25 = 22;
        km = 22;
        min = 2;
        price = 950;
    }

    void onClickGazelleLongFarmer() {
        km25 = 22;
        km = 22;
        min = 2;
        price = 900;
    }

    void onClickGazelleLongRef() {
        km25 = 23;
        km = 23;
        min = 3;
        price = 900;
    }

    void onClickGazelleLongPyramid() {
        km25 = 23;
        km = 23;
        min = 3;
        price = 900;
    }

    void onClickGazelleLongHaight() {
        km25 = 22;
        km = 22;
        min = 3;
        price = 900;
    }

    void onClickGazelleLongLong() {
        km25 = 25;
        km = 25;
        min = 3;
        price = 1000;
    }

    void onClickTon2Original() {
        km25 = 22;
        km = 22;
        min = 2;
        price = 800;
    }

    void onClickTon2Board() {
        km25 = 23;
        km = 23;
        min = 2;
        price = 950;
    }

    void onClickTon2Farmer() {
        km25 = 23;
        km = 23;
        min = 2;
        price = 900;
    }

    void onClickTon2Ref() {
        km25 = 24;
        km = 24;
        min = 3;
        price = 900;
    }

    void onClickTon2Pyramid() {
        km25 = 24;
        km = 24;
        min = 3;
        price = 900;
    }

    void onClickTon2Haight() {
        km25 = 23;
        km = 23;
        min = 3;
        price = 900;
    }

    void onClickTon2Long() {
        km25 = 25;
        km = 25;
        min = 3;
        price = 1000;
    }

    void onClickTon3OriginalMini() {
        km25 = 0;
        km = 24;
        min = 3;
        price = 900;
    }

    void onClickTon3OriginalMaxi() {
        km25 = 0;
        km = 25;
        min = 3;
        price = 1000;
    }

    void onClickTon3Board() {
        km25 = 0;
        km = 25;
        min = 3;
        price = 1000;
    }

    void onClickTon3Farmer() {
        km25 = 0;
        km = 25;
        min = 3;
        price = 1000;
    }

    void onClickTon3Ref() {
        km25 = 0;
        km = 26;
        min = 3;
        price = 1000;
    }

    void onClickTon3MultiRef() {
        km25 = 0;
        km = 26;
        min = 3;
        price = 1100;
    }

    void onClickTon3Pyramid() {
        km25 = 0;
        km = 26;
        min = 3;
        price = 1050;
    }

    void onClickTon3Long() {
        km25 = 0;
        km = 25;
        min = 3;
        price = 1000;
    }

    void onClickTon5Mini() {
        km25 = 0;
        km = 28;
        min = 3;
        price = 1150;
    }

    void onClickTon5Medium() {
        km25 = 0;
        km = 30;
        min = 3;
        price = 1250;
    }

    void onClickTon5Maxi() {
        km25 = 0;
        km = 32;
        min = 4;
        price = 1350;
    }

    void onClickTon5Board() {
        km25 = 0;
        km = 30;
        min = 3;
        price = 1250;
    }

    void onClickTon5RefMini() {
        km25 = 0;
        km = 30;
        min = 4;
        price = 1250;
    }

    void onClickTon5RefMaxi() {
        km25 = 0;
        km = 32;
        min = 4;
        price = 1350;
    }

    void onClickTon7Min() {
        km25 = 0;
        km = 35;
        min = 4;
        price = 1350;
    }

    void onClickTon7Max() {
        km25 = 0;
        km = 36;
        min = 4;
        price = 1450;
    }

    void onClickTon7Board() {
        km25 = 0;
        km = 37;
        min = 4;
        price = 1450;
    }

    void onClickTon7RefMin() {
        km25 = 0;
        km = 37;
        min = 4;
        price = 1450;
    }

    void onClickTon7RefMax() {
        km25 = 0;
        km = 38;
        min = 4;
        price = 1550;
    }

    void onClickTon10Min() {
        km25 = 0;
        km = 41;
        min = 4;
        price = 1500;
    }

    void onClickTon10Max() {
        km25 = 0;
        km = 42;
        min = 4;
        price = 1600;
    }

    void onClickTon10Board() {
        km25 = 0;
        km = 43;
        min = 4;
        price = 1600;
    }

    void onClickTon10RefMin() {
        km25 = 0;
        km = 43;
        min = 4;
        price = 1600;
    }

    void onClickTon10RefMax() {
        km25 = 0;
        km = 44;
        min = 4;
        price = 1700;
    }
}