package com.kingdee.dome.webapi.entities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AssetsCard implements Serializable {
    /**
     * NeedUpDateFields : []
     * NeedReturnFields : []
     * IsDeleteEntry : true
     * SubSystemId :
     * IsVerifyBaseDataField : false
     * IsEntryBatchFill : true
     * ValidateFlag : true
     * NumberSearch : true
     * IsAutoAdjustField : false
     * InterationFlags :
     * IgnoreInterationFlag :
     * Model : {"FAlterID":0,"FAssetOrgID":{"FNumber":"100"},"FOwnerOrgID":{"FNumber":"100"},"FAssetTypeID":{"FNumber":"ZCLB04_SYS"},"FNumber":"1","FName":"测试","FUnitID":{"FNUMBER":"cm"},"FQuantity":1,"FAssetStatusID":{"FNumber":"ZCZT01_SYS"},"FAlterModeID":{"FNumber":"BDFS01_SYS"},"FBeginUseDate":"2021-10-14 00:00:00","FDocumentStatus":"Z","FIsInit":false,"FCardDetail":[{"FAssetNO":"1","FDetailQuantity":1,"FCanRecipientQty":1,"FIsInsured":true}],"FAllocation":[{"FAllocAssetNO":"1","FAllocRatio":100}]}
     */

    private String IsDeleteEntry;
    private String SubSystemId;
    private String IsVerifyBaseDataField;
    private String IsEntryBatchFill;
    private String ValidateFlag;
    private String NumberSearch;
    private String IsAutoAdjustField;
    private String InterationFlags;
    private String IgnoreInterationFlag;
    private ModelBean Model;
    private List<?> NeedUpDateFields;
    private List<?> NeedReturnFields;

    @Data
    public static class ModelBean implements Serializable {
        /**
         * FAlterID : 0
         * FAssetOrgID : {"FNumber":"100"}
         * FOwnerOrgID : {"FNumber":"100"}
         * FAssetTypeID : {"FNumber":"ZCLB04_SYS"}
         * FNumber : 1
         * FName : 测试
         * FUnitID : {"FNUMBER":"cm"}
         * FQuantity : 1.0
         * FAssetStatusID : {"FNumber":"ZCZT01_SYS"}
         * FAlterModeID : {"FNumber":"BDFS01_SYS"}
         * FBeginUseDate : 2021-10-14 00:00:00
         * FDocumentStatus : Z
         * FIsInit : false
         * FCardDetail : [{"FAssetNO":"1","FDetailQuantity":1,"FCanRecipientQty":1,"FIsInsured":true}]
         * FAllocation : [{"FAllocAssetNO":"1","FAllocRatio":100}]
         */

        private int FAlterID;
        private FAssetOrgIDBean FAssetOrgID;
        private FOwnerOrgIDBean FOwnerOrgID;
        private FAssetTypeIDBean FAssetTypeID;
        private String FNumber;
        private String FName;
        private FUnitIDBean FUnitID;
        private double FQuantity;
        private FAssetStatusIDBean FAssetStatusID;
        private FAlterModeIDBean FAlterModeID;
        private String FBeginUseDate;
        private String FDocumentStatus;
        private boolean FIsInit;
        private List<FCardDetailBean> FCardDetail;
        private List<FAllocationBean> FAllocation;

        @Data
        public static class FAssetOrgIDBean implements Serializable {
            /**
             * FNumber : 100
             */

            private String FNumber;
        }

        @Data
        public static class FOwnerOrgIDBean implements Serializable {
            /**
             * FNumber : 100
             */

            private String FNumber;
        }

        @Data
        public static class FAssetTypeIDBean implements Serializable {
            /**
             * FNumber : ZCLB04_SYS
             */

            private String FNumber;
        }

        @Data
        public static class FUnitIDBean implements Serializable {
            /**
             * FNUMBER : cm
             */

            @SerializedName("FNUMBER")
            private String fnumber;
        }

        @Data
        public static class FAssetStatusIDBean implements Serializable {
            /**
             * FNumber : ZCZT01_SYS
             */

            private String FNumber;
        }

        @Data
        public static class FAlterModeIDBean implements Serializable {
            /**
             * FNumber : BDFS01_SYS
             */

            private String FNumber;
        }

        @Data
        public static class FCardDetailBean implements Serializable {
            /**
             * FAssetNO : 1
             * FDetailQuantity : 1.0
             * FCanRecipientQty : 1.0
             * FIsInsured : true
             */

            private String FAssetNO;
            private double FDetailQuantity;
            private double FCanRecipientQty;
            private boolean FIsInsured;
        }

        @Data
        public static class FAllocationBean implements Serializable {
            /**
             * FAllocAssetNO : 1
             * FAllocRatio : 100.0
             */

            private String FAllocAssetNO;
            private double FAllocRatio;
        }
    }
}
