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

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

/**
 *
 * @author alexript
 */
public enum Win10Toast {
    INFO(new Win10ToastPainter(MessageType.INFO)),
    ERROR(new Win10ToastPainter(MessageType.ERROR)),
    WARNING(new Win10ToastPainter(MessageType.WARNING));

    private final Win10ToastPainter painter;

    private Win10Toast(Win10ToastPainter painter) {
        this.painter = painter;
    }

    /**
     * Display toast with message
     * 
     * @param title
     * @param message 
     */
    public void show(String title, String message) {
        painter.show(title, message);
    }

    /**
     * Assign application tray icon to Win10Toast classes
     * @param trayIcon 
     */
    public static void setTrayIcon(TrayIcon trayIcon) {
        Win10ToastPainter.setTrayIcon(trayIcon);
    }

}
