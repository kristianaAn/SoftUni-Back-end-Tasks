package lection_11_SOLID_lab.solidLab.p04_InterfaceSegregation.p02_identity;

import lection_11_SOLID_lab.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Account;
import lection_11_SOLID_lab.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.RegistrationRestrictions;

public class AccountManager implements Account, RegistrationRestrictions {
    private boolean requireUniqueEmail;
    private int minRequiredPasswordLength;
    private int maxRequiredPasswordLength;


    @Override
    public boolean getRequireUniqueEmail() {
        return this.requireUniqueEmail;
    }

    @Override
    public int getMinRequiredPasswordLength() {
        return this.minRequiredPasswordLength;
    }

    @Override
    public int getMaxRequiredPasswordLength() {
        return this.maxRequiredPasswordLength;
    }

    @Override
    public void register(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void login(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        //change password
    }
}
