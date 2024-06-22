package jlink.restful.java.sdk.module.boss;

import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.module.passengerFlow.ResetOSDResponse;

/**
 * boss Object
 */
public class JFTechBoss {

    private JLinkClient mJLinkClient = null;

    public JFTechBoss(JLinkClient jClient) {
        this.mJLinkClient = jClient;
    }

    /**
     * Get Card Pool List
     *
     * @param
     * @return {@link ResetOSDResponse.RestOSD}
     */
    public BossListCardPoolResponse listCardPool() {
        return new JFTechBossRequest().listCardPool(mJLinkClient);
    }

    /**
     * Card Apply
     *
     * @param
     * @return {@link ResetOSDResponse.RestOSD}
     */
    public BossCardApplyResponse cardApply(String sn, String userId, String cardId, String cardPass) {
        return cardApply(sn, "", "0", userId, cardId, cardPass);
    }

    public BossCardApplyResponse cardApply(String sn, String devName, String channel, String userId, String cardId, String cardPass) {
        return new JFTechBossRequest().cardApply(sn, devName, channel, userId, cardId, cardPass, "", mJLinkClient);
    }

    public BossCardApplyResponse cardApply(String sn, String userId, String goodsCode) {
        return cardApply(sn, "", "0", userId, goodsCode);
    }

    public BossCardApplyResponse cardApply(String sn, String devName, String channel, String userId, String goodsCode) {
        return new JFTechBossRequest().cardApply(sn, devName, channel, userId, "", "", goodsCode, mJLinkClient);
    }

    /**
     * Transfer Card
     *
     * @param fromSn
     * @param toSn
     * @param cardId
     * @return {@link BossTransferCardResponse}
     */
    public BossTransferCardResponse transferCard(String fromSn, String toSn, String cardId) {
        return transferCard(fromSn, toSn, 0, 0, cardId);
    }

    public BossTransferCardResponse transferCard(String fromSn, String toSn, int fromChannel, int toChannel, String cardId) {
        return new JFTechBossRequest().transferCard(fromSn, toSn, fromChannel, toChannel, cardId, mJLinkClient);
    }

    /**
     * Card Used Info
     *
     * @param cardId
     * @return {@link BossCardUsedInfoResponse}
     */
    public BossCardUsedInfoResponse cardUsedInfo(String cardId) {
        return new JFTechBossRequest().cardUsedInfo(cardId, mJLinkClient);
    }

}
