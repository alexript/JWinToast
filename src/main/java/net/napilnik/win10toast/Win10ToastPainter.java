/*
 * The MIT License
 *
 * Copyright 2020 alexript.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.napilnik.win10toast;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexript
 */
class Win10ToastPainter {

    private final MessageType type;

    private static TrayIcon applicationTrayIcon = null;

    protected Win10ToastPainter(MessageType toastType) {
        this.type = toastType;
    }

    protected static void setTrayIcon(TrayIcon trayIcon) {
        SystemTray tray = SystemTray.getSystemTray();
        synchronized (Win10ToastPainter.class) {
            if (applicationTrayIcon != null) {
                tray.remove(applicationTrayIcon);
            }
            applicationTrayIcon = trayIcon;
            if (applicationTrayIcon != null) {
                try {
                    tray.add(applicationTrayIcon);
                } catch (AWTException ex) {
                    Logger.getLogger(Win10ToastPainter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    protected void show(String title, String message) {
        synchronized (Win10ToastPainter.class) {
            if (applicationTrayIcon == null) {
                setTrayIcon(ApplicationTrayIcon.DEFAULT_TRAY_ICON);
            }
            if (applicationTrayIcon != null) {
                applicationTrayIcon.displayMessage(title, message, type);
            }
        }
    }

}
