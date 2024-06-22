package jlink.restful.java.sdk.module.boss;

import java.util.List;

/**
 * @author hjm
 * @date 2024/06/21
 */
public class BossCardUsedInfoResponse {
    private Integer code;
    private String msg;
    private CardUsedInfoDto data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CardUsedInfoDto getData() {
        return data;
    }

    public void setData(CardUsedInfoDto data) {
        this.data = data;
    }

    public static class CardUsedInfoDto {

        private String id;
        private String goodsName;
        private String expirationTime;
        private String capsExpirationTime;
        private String usedTime;
        private OrderInfoDTO orderInfo;


        public static class OrderInfoDTO {
            private Integer id;
            private String userId;
            private Integer channel;
            private String status;
            private Boolean del;
            private String price;
            private String balance;
            private String discount;
            private String tradeNo;
            private String totalAmount;
            private Boolean refund;
            private String payType;
            private String createMillis;
            private String payMillis;
            private String openMillis;
            private String oem;
            private String symbol;
            private String ip;
            private String uuidArea;
            private List<DetailVo> detailVos;
            private List<RefundVo> refundVos;
            private String sn;

            public static class DetailVo {
                private int goodsId;
                private String name;
                private String classify;
                private String price;
                private String totalPrice;
                private String discount;
                private String priceUnit;
                private boolean up;
                private boolean forever;
                private int buyNum;
                private String introduce;
                private String icon;

                public int getGoodsId() {
                    return goodsId;
                }

                public String getName() {
                    return name;
                }

                public String getClassify() {
                    return classify;
                }

                public String getPrice() {
                    return price;
                }

                public String getTotalPrice() {
                    return totalPrice;
                }

                public String getDiscount() {
                    return discount;
                }

                public String getPriceUnit() {
                    return priceUnit;
                }

                public boolean isUp() {
                    return up;
                }

                public boolean isForever() {
                    return forever;
                }

                public int getBuyNum() {
                    return buyNum;
                }

                public String getIntroduce() {
                    return introduce;
                }

                public String getIcon() {
                    return icon;
                }
            }

            public static class RefundVo {
                private String timeMills;
                private String amount;

                public String getTimeMills() {
                    return timeMills;
                }

                public String getAmount() {
                    return amount;
                }
            }

            public Integer getId() {
                return id;
            }

            public String getUserId() {
                return userId;
            }

            public Integer getChannel() {
                return channel;
            }

            public String getStatus() {
                return status;
            }

            public Boolean getDel() {
                return del;
            }

            public String getPrice() {
                return price;
            }

            public String getBalance() {
                return balance;
            }

            public String getDiscount() {
                return discount;
            }

            public String getTradeNo() {
                return tradeNo;
            }

            public String getTotalAmount() {
                return totalAmount;
            }

            public Boolean getRefund() {
                return refund;
            }

            public String getPayType() {
                return payType;
            }

            public String getCreateMillis() {
                return createMillis;
            }

            public String getPayMillis() {
                return payMillis;
            }

            public String getOpenMillis() {
                return openMillis;
            }

            public String getOem() {
                return oem;
            }

            public String getSymbol() {
                return symbol;
            }

            public String getIp() {
                return ip;
            }

            public String getUuidArea() {
                return uuidArea;
            }

            public List<DetailVo> getDetailVos() {
                return detailVos;
            }

            public List<RefundVo> getRefundVos() {
                return refundVos;
            }

            public String getSn() {
                return sn;
            }
        }

        public String getId() {
            return id;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public String getExpirationTime() {
            return expirationTime;
        }

        public String getCapsExpirationTime() {
            return capsExpirationTime;
        }

        public String getUsedTime() {
            return usedTime;
        }

        public OrderInfoDTO getOrderInfo() {
            return orderInfo;
        }
    }
}
