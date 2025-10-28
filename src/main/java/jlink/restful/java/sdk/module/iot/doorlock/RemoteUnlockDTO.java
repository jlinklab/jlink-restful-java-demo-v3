package jlink.restful.java.sdk.module.iot.doorlock;

public class RemoteUnlockDTO {

    private String sn;
    private PropsDTO props;

    public RemoteUnlockDTO(String sn, String password) {
        this.sn = sn;
        this.props = new PropsDTO();
        this.props.setDoorLock(new PropsDTO.DoorLockDTO());
        this.props.getDoorLock().setRemoteUnlock(new PropsDTO.DoorLockDTO.RemoteUnlock());
        this.props.getDoorLock().getRemoteUnlock().setPassword(password);
    }

    public static class PropsDTO {
        private DoorLockDTO doorLock;

        public static class DoorLockDTO {
            private RemoteUnlock remoteUnlock;

            public static class RemoteUnlock {
                private String password;

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }
            }

            public RemoteUnlock getRemoteUnlock() {
                return remoteUnlock;
            }

            public void setRemoteUnlock(RemoteUnlock remoteUnlock) {
                this.remoteUnlock = remoteUnlock;
            }
        }

        public DoorLockDTO getDoorLock() {
            return doorLock;
        }

        public void setDoorLock(DoorLockDTO doorLock) {
            this.doorLock = doorLock;
        }
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public PropsDTO getProps() {
        return props;
    }

    public void setProps(PropsDTO props) {
        this.props = props;
    }
}
