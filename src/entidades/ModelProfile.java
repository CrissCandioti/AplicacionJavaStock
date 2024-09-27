/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.File;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import raven.extras.AvatarIcon;

/**
 *
 * @author criss
 */
@Entity
public class ModelProfile {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public ModelProfile(File path) {
        this.path = path;
    }

    public ModelProfile(byte[] bytes) {
        if (bytes != null) {
            icon = new ImageIcon(bytes);
        }
    }

    public ModelProfile(Icon icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Icon getAvatar() {
        return avatar;
    }

    public void setAvatar(Icon avatar) {
        this.avatar = avatar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private byte[] contenido;
    private Icon icon;
    private Icon avatar;
    private File path;

    public Icon getAvatarIcon() {
        if (icon == null) {
            return null;
        }
        if (avatar == null) {
            AvatarIcon ai = new AvatarIcon(icon, 50, 50, 3f);
            ai.setType(AvatarIcon.Type.MASK_SQUIRCLE);
            avatar = ai;
        }
        return avatar;
    }
}
