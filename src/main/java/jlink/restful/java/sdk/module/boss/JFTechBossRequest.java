package jlink.restful.java.sdk.module.boss;

import com.google.gson.Gson;
import jlink.restful.java.sdk.JLinkClient;
import jlink.restful.java.sdk.competent.JLinkDomain;
import jlink.restful.java.sdk.competent.JLinkMethodType;
import jlink.restful.java.sdk.competent.JLinkResponseCode;
import jlink.restful.java.sdk.exception.JLinkJsonException;
import jlink.restful.java.sdk.util.JLinkHeaderUtil;
import jlink.restful.java.sdk.util.JLinkHttpUtil;

import java.util.HashMap;
import java.util.Map;


/**
 * @author hjm
 * @date 2024/06/21
 */
public class JFTechBossRequest {

    /**
     * Get Card Pool List
     *
     * @param mJLinkClient
     * @return {@link BossListCardPoolResponse}
     */
    public BossListCardPoolResponse listCardPool(JLinkClient mJLinkClient) {
        String url = String.format("%s/%s", JLinkDomain.BOSS_DOMAIN.get(), JFTechBossRequestUrl.LIST_CARD_POOL.get());
        String res = JLinkHttpUtil.httpsRequest(url, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), "{}");

        try {
            return new Gson().fromJson(res, BossListCardPoolResponse.class);
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    /**
     * Card Apply
     *
     * @param sn
     * @param devName
     * @param channel
     * @param userId
     * @param cardId
     * @param cardPass
     * @param goodsCode
     * @param mJLinkClient
     * @return {@link BossCardApplyResponse}
     */
    public BossCardApplyResponse cardApply(String sn, String devName, String channel, String userId, String cardId, String cardPass, String goodsCode, JLinkClient mJLinkClient) {
        String url = String.format("%s/%s", JLinkDomain.BOSS_DOMAIN.get(), JFTechBossRequestUrl.CARD_APPLY.get());
        Map<String, String> body = new HashMap<>();
        body.put("sn", sn);
        body.put("userId", userId);
        body.put("devName", devName);
        body.put("channel", channel);
        body.put("cardId", cardId);
        body.put("cardPass", cardPass);
        body.put("goodsCode", goodsCode);
        String res = JLinkHttpUtil.httpsRequest(url, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(body));
        try {
            return new Gson().fromJson(res, BossCardApplyResponse.class);
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    /**
     * transferCard
     *
     * @param fromSn
     * @param toSn
     * @param fromChannel
     * @param toChannel
     * @param cardId
     * @param mJLinkClient
     * @return {@link BossTransferCardResponse}
     */
    public BossTransferCardResponse transferCard(String fromSn, String toSn, int fromChannel, int toChannel, String cardId, JLinkClient mJLinkClient) {
        String url = String.format("%s/%s", JLinkDomain.BOSS_DOMAIN.get(), JFTechBossRequestUrl.TRANSFER_CARD.get());
        Map<String, Object> body = new HashMap<>();
        body.put("fromSn", fromSn);
        body.put("fromChannel", fromChannel);
        body.put("toSn", toSn);
        body.put("toChannel", toChannel);
        body.put("cardId", cardId);
        String res = JLinkHttpUtil.httpsRequest(url, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(body));
        try {
            return new Gson().fromJson(res, BossTransferCardResponse.class);
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

    public BossCardUsedInfoResponse cardUsedInfo(String cardId, JLinkClient mJLinkClient) {
        String url = String.format("%s/%s", JLinkDomain.BOSS_DOMAIN.get(), JFTechBossRequestUrl.CARD_USED_INFO.get());
        Map<String, Object> body = new HashMap<>();
        body.put("cardId", cardId);
        String res = JLinkHttpUtil.httpsRequest(url, JLinkMethodType.POST.get(), JLinkHeaderUtil.map(mJLinkClient), new Gson().toJson(body));
        try {
            return new Gson().fromJson(res, BossCardUsedInfoResponse.class);
        } catch (Exception e) {
            throw new JLinkJsonException(JLinkResponseCode.JSON_ERROR.getCode(), res);
        }
    }

}
