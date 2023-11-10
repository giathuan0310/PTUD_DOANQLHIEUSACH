package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class GUI_HoaDon extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField tfMhd;
	private JTextField tfMnv;
	private JTable table;
	private JTextField tfMq;
	private JTextField tfMkh;
	private JTextField tfNl;
	private JTextField textField_6;
	private JTextField jtMs;
	private JTextField jtTens;
	private JTextField jtSl;
	private JTextField jtDg;
	private JTextField jtVAT;
	private JTextField jtUd;
	private JTextField jtTht;
	private JTextField jtTt;
	private JTextField jtTn;
	private JTextField jtTthua;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_HoaDon frame = new GUI_HoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_HoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý nhà cung cấp");
		setBounds(100, 100, 1150, 680);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(234, 198, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 57, 70));
		panel.setBounds(0, 0, 165, 58);
		contentPane.add(panel);
		
		 JLabel lblNewLabel_1 = new JLabel("");
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(255, 255, 255));
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 lblNewLabel_1.setBackground(new Color(17, 57, 70));
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblNewLabel.setForeground(new Color(234, 198, 150));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(387, -12, 387, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setVerticalAlignment(SwingConstants.BOTTOM);
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/khachhang_img.png")));
		btnKhachHang.setForeground(new Color(255, 255, 255));
		btnKhachHang.setBackground(new Color(17, 57, 70));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhachHang.setBounds(0, 59, 165, 58);
		btnKhachHang.setContentAreaFilled(false);
		btnKhachHang.setFocusPainted(false);
		btnKhachHang.setOpaque(true);
		contentPane.add(btnKhachHang);
		
		btnKhachHang.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnKhachHang.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnKhachHang.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
	       JPopupMenu popupMenu = new JPopupMenu();
	        JMenuItem menuItemThem = new JMenuItem("Thêm khách hàng");
	        menuItemThem.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
	        menuItemThem.setForeground(new Color(255, 255, 255)); // Set text color
	        menuItemThem.setBackground(new Color(136, 74, 57)); // Set background color
	        menuItemThem.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Set font
	        menuItemThem.setPreferredSize(new Dimension(163, 58));
	        popupMenu.add(menuItemThem);
	        
	        JMenuItem menuItemCapNhat = new JMenuItem("Cập nhật khách hàng");
	        menuItemCapNhat.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
	        menuItemCapNhat.setForeground(new Color(255, 255, 255));
	        menuItemCapNhat.setBackground(new Color(136, 74, 57));
	        menuItemCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        menuItemCapNhat.setPreferredSize(new Dimension(163, 58));
	        popupMenu.add(menuItemCapNhat);
	        
	        JMenuItem menuItemTimKiem = new JMenuItem("Tìm khách hàng");
	        menuItemTimKiem.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
	        menuItemTimKiem.setForeground(new Color(255, 255, 255));
	        menuItemTimKiem.setBackground(new Color(136, 74, 57));
	        menuItemTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        menuItemTimKiem.setPreferredSize(new Dimension(163, 58));
	        popupMenu.add(menuItemTimKiem);


	        btnKhachHang.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Show the pop-up menu when the "Khách hàng" button is clicked
	                popupMenu.show(btnKhachHang, 0, btnKhachHang.getHeight());
	            }
	        });

	        menuItemThem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "Thêm" here
	            }
	        });

	        menuItemCapNhat.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "Cập nhật" here
	            }
	        });

	        menuItemTimKiem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "tìm kiếm" here
	            }
	        });
		
		JButton btnSach = new JButton("Sách\r\n");
		btnSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnSach.setVerticalAlignment(SwingConstants.TOP);
		btnSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/sach_img.png")));
		btnSach.setForeground(new Color(255, 255, 255));
		btnSach.setBackground(new Color(17, 57, 70));
		btnSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSach.setBounds(164, 59, 159, 58);
		btnSach.setContentAreaFilled(false);
		btnSach.setFocusPainted(false);
		btnSach.setOpaque(true);
		contentPane.add(btnSach);
		
		btnSach.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnSach.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnSach.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
	     JPopupMenu popupMenuSach = new JPopupMenu();
	     JMenuItem menuItemThemSach = new JMenuItem("Thêm sách");
	        menuItemThemSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
	        menuItemThemSach.setForeground(new Color(255, 255, 255)); 
	        menuItemThemSach.setBackground(new Color(136, 74, 57)); 
	        menuItemThemSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemThemSach.setPreferredSize(new Dimension(157, 58));
	        menuItemThemSach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI_Sach gui_Sach = new GUI_Sach();
					gui_Sach.setVisible(true);
		            dispose();

				}
			});
	        popupMenuSach.add(menuItemThemSach);
	        
	        JMenuItem menuItemCapNhatSach = new JMenuItem("Cập nhật sách");
	        menuItemCapNhatSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
	        menuItemCapNhatSach.setForeground(new Color(255, 255, 255)); 
	        menuItemCapNhatSach.setBackground(new Color(136, 74, 57));
	        menuItemCapNhatSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemCapNhatSach.setPreferredSize(new Dimension(157, 58));
	        menuItemCapNhatSach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI_Sach gui_Sach = new GUI_Sach();
					gui_Sach.setVisible(true);
		            dispose();

				}
			});
	        popupMenuSach.add(menuItemCapNhatSach);
	        
	        JMenuItem menuItemTimKiemSach = new JMenuItem("Tìm kiếm sách");
	        menuItemTimKiemSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
	        menuItemTimKiemSach.setForeground(new Color(255, 255, 255)); 
	        menuItemTimKiemSach.setBackground(new Color(136, 74, 57)); 
	        menuItemTimKiemSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemTimKiemSach.setPreferredSize(new Dimension(157, 58));
	        menuItemTimKiemSach.addActionListener(new ActionListener() {
	  				public void actionPerformed(ActionEvent e) {
	  					GUI_Sach gui_Sach = new GUI_Sach();
	  					gui_Sach.setVisible(true);
			            dispose();

	  				}
	  			});
	        popupMenuSach.add(menuItemTimKiemSach);
	        
	        JMenuItem menuItemXoaSach = new JMenuItem("Xóa sách");
	        menuItemXoaSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/delete_img.png")));
	        menuItemXoaSach.setForeground(new Color(255, 255, 255)); 
	        menuItemXoaSach.setBackground(new Color(136, 74, 57)); 
	        menuItemXoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemXoaSach.setPreferredSize(new Dimension(157, 58));
	        menuItemXoaSach.addActionListener(new ActionListener() {
	  				public void actionPerformed(ActionEvent e) {
	  					GUI_Sach gui_Sach = new GUI_Sach();
	  					gui_Sach.setVisible(true);
			            dispose();

	  				}
	  			});
	        popupMenuSach.add(menuItemXoaSach);
	        
	        btnSach.addActionListener(new ActionListener() {
	        	  public void actionPerformed(ActionEvent e) {
		                
	        		  popupMenuSach.show(btnSach, 0, btnSach.getHeight());
		            }
		        });
	        menuItemThemSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	            }
	        });
	        popupMenuSach.add(menuItemThemSach);

	      
	       
	        menuItemCapNhatSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              
	            }
	        });
	        popupMenuSach.add(menuItemCapNhatSach);

	      
	        
	        menuItemTimKiemSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            
	            }
	        });
	        popupMenuSach.add(menuItemTimKiemSach);

	       
	       
	        menuItemXoaSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	             
	            }
	        });
	        popupMenuSach.add(menuItemXoaSach);

	       
	        btnSach.setComponentPopupMenu(popupMenuSach);
	   

		
		
		
		JButton btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/bill_imng.png")));
		btnHoaDon.setForeground(new Color(255, 255, 255));
		btnHoaDon.setBackground(new Color(17, 57, 70));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHoaDon.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setBounds(322, 59, 165, 58);
		btnHoaDon.setContentAreaFilled(false);
		btnHoaDon.setFocusPainted(false);
		btnHoaDon.setOpaque(true);
		contentPane.add(btnHoaDon);
		
		btnHoaDon.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnHoaDon.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnHoaDon.setBackground(new Color(17, 57, 70));
		    }
		});
		
		JPopupMenu popupMenuHoaDon = new JPopupMenu();
		JMenuItem menuItemTaoHoaDon = new JMenuItem("Tạo hóa đơn");
		menuItemTaoHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemTaoHoaDon.setForeground(new Color(255, 255, 255));
		menuItemTaoHoaDon.setBackground(new Color(136, 74, 57));
		menuItemTaoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTaoHoaDon.setPreferredSize(new Dimension(163, 58));
		menuItemTaoHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_HoaDon guiHoaDon = new GUI_HoaDon();
				guiHoaDon.setVisible(true);
				dispose();
				
			}
		});
		popupMenuHoaDon.add(menuItemTaoHoaDon);

		
		JMenuItem menuItemXemChiTietHoaDon = new JMenuItem("Xem chi tiết hóa đơn");
		menuItemXemChiTietHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/payment_img.png")));
		menuItemXemChiTietHoaDon.setForeground(new Color(255, 255, 255));
		menuItemXemChiTietHoaDon.setBackground(new Color(136, 74, 57));
		menuItemXemChiTietHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemXemChiTietHoaDon.setPreferredSize(new Dimension(163, 58));
		menuItemXemChiTietHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_QLHD guiqlyHoaDon = new GUI_QLHD();
				guiqlyHoaDon.setVisible(true);
				dispose();
				
			}
		});
		popupMenuHoaDon.add(menuItemXemChiTietHoaDon);

	
		btnHoaDon.setComponentPopupMenu(popupMenuHoaDon);


		btnHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     
		        popupMenuHoaDon.show(btnHoaDon, 0, btnHoaDon.getHeight());
		    }
		});

		menuItemTaoHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      
		    }
		});

		menuItemXemChiTietHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});
		
		JButton btnNhanVIen = new JButton("Nhân viên");
		btnNhanVIen.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVIen.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/nhanvien_img.png")));
		btnNhanVIen.setForeground(new Color(255, 255, 255));
		btnNhanVIen.setBackground(new Color(17, 57, 70));
		btnNhanVIen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNhanVIen.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNhanVIen.setBounds(486, 59, 165, 58);
		btnNhanVIen.setContentAreaFilled(false);
		btnNhanVIen.setFocusPainted(false);
		btnNhanVIen.setOpaque(true);
		contentPane.add(btnNhanVIen);
		
		btnNhanVIen.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnNhanVIen.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnNhanVIen.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
		JPopupMenu popupMenuNhanVien = new JPopupMenu();
		JMenuItem menuItemThemNhanVien = new JMenuItem("Thêm nhân viên");
		menuItemThemNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemThemNhanVien.setForeground(new Color(255, 255, 255));
		menuItemThemNhanVien.setBackground(new Color(136, 74, 57));
		menuItemThemNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemThemNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemThemNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemThemNhanVien);

		
		JMenuItem menuItemCapNhatNhanVien = new JMenuItem("Cập nhật nhân viên");
		menuItemCapNhatNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNhanVien.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNhanVien.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemCapNhatNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemCapNhatNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemCapNhatNhanVien);

		
		JMenuItem menuItemTimKiemNhanVien = new JMenuItem("Tìm nhân viên");
		menuItemTimKiemNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNhanVien.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNhanVien.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemTimKiemNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemTimKiemNhanVien);

		
		JMenuItem menuItemXoaNhanVien = new JMenuItem("Xóa nhân viên");
		menuItemXoaNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/delete_img.png")));
		menuItemXoaNhanVien.setForeground(new Color(255, 255, 255));
		menuItemXoaNhanVien.setBackground(new Color(136, 74, 57));
		menuItemXoaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemXoaNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemXoaNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemXoaNhanVien);


	
		JMenuItem menuItemXemNhanVienBiXoa = new JMenuItem("Xem nhân viên bị xóa");
		menuItemXemNhanVienBiXoa.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/erase_img.png")));
		menuItemXemNhanVienBiXoa.setForeground(new Color(255, 255, 255));
		menuItemXemNhanVienBiXoa.setBackground(new Color(136, 74, 57));
		menuItemXemNhanVienBiXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemXemNhanVienBiXoa.setPreferredSize(new Dimension(163, 58));
		popupMenuNhanVien.add(menuItemXemNhanVienBiXoa);

		menuItemXemNhanVienBiXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Tạo một thể hiện của GUI_NhanVien
		        GUI_XemTTNVbixoa guiXemTTNVbixoa = new GUI_XemTTNVbixoa();

		        // Ẩn giao diện hiện tại 
		        setVisible(false);

		        // Hiển thị giao diện mới
		        guiXemTTNVbixoa.setVisible(true);
		    }
		});
		btnNhanVIen.setComponentPopupMenu(popupMenuNhanVien);

		
		btnNhanVIen.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        popupMenuNhanVien.show(btnNhanVIen, 0, btnNhanVIen.getHeight());
		    }
		});

		menuItemThemNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    }
		});

		menuItemCapNhatNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    }
		});

		menuItemTimKiemNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		 
		    }
		});

		menuItemXoaNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    
		    }
		});

		menuItemXemNhanVienBiXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		  
		    }
		});
		
		JButton btnNhaCungCap = new JButton("Nhà cung cấp");
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/ncc_img.png")));
		btnNhaCungCap.setForeground(new Color(255, 255, 255));
		btnNhaCungCap.setBackground(new Color(17, 57, 70));
		btnNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNhaCungCap.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {				
			}
		});
		btnNhaCungCap.setBounds(650, 59, 165, 58);
		btnNhaCungCap.setContentAreaFilled(false);
		btnNhaCungCap.setFocusPainted(false);
		btnNhaCungCap.setOpaque(true);
		contentPane.add(btnNhaCungCap);
		
		btnNhaCungCap.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnNhaCungCap.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnNhaCungCap.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
		
		JPopupMenu popupMenuNCC = new JPopupMenu();
		JMenuItem menuItemThemNCC = new JMenuItem("Thêm NCC");
		menuItemThemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemThemNCC.setForeground(new Color(255, 255, 255));
		menuItemThemNCC.setBackground(new Color(136, 74, 57));
		menuItemThemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemThemNCC.setPreferredSize(new Dimension(163, 58));
		menuItemThemNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhaCungCap guiNhaCungCap = new GUI_NhaCungCap();
				guiNhaCungCap.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNCC.add(menuItemThemNCC);

		
		JMenuItem menuItemCapNhatNCC = new JMenuItem("Cập nhật NCC");
		menuItemCapNhatNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNCC.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNCC.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemCapNhatNCC.setPreferredSize(new Dimension(163, 58));
		menuItemCapNhatNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhaCungCap guiNhaCungCap = new GUI_NhaCungCap();
				guiNhaCungCap.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNCC.add(menuItemCapNhatNCC);

	
		JMenuItem menuItemTimKiemNCC = new JMenuItem("Tìm NCC");
		menuItemTimKiemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNCC.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNCC.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNCC.setPreferredSize(new Dimension(163, 58));
		menuItemTimKiemNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhaCungCap guiNhaCungCap = new GUI_NhaCungCap();
				guiNhaCungCap.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNCC.add(menuItemTimKiemNCC);

		
		btnNhaCungCap.setComponentPopupMenu(popupMenuNCC);

	
		btnNhaCungCap.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        popupMenuNCC.show(btnNhaCungCap, 0, btnNhaCungCap.getHeight());
		    }
		});

		menuItemThemNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemCapNhatNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemTimKiemNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     
		    }
		});
		
		JButton btnTroGiup = new JButton("Trợ giúp");
		btnTroGiup.setIcon(new ImageIcon(GUI_HoaDon.class.getResource("/imgs/help_img.png")));
		btnTroGiup.setHorizontalAlignment(SwingConstants.LEFT);
		btnTroGiup.setForeground(new Color(255, 255, 255));
		btnTroGiup.setBackground(new Color(17, 57, 70));
		btnTroGiup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTroGiup.setBounds(814, 59, 165, 58);
		btnTroGiup.setContentAreaFilled(false);
		btnTroGiup.setFocusPainted(false);
		btnTroGiup.setOpaque(true);
		contentPane.add(btnTroGiup);
		
		btnTroGiup.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnTroGiup.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnTroGiup.setBackground(new Color(17, 57, 70));
		    }
		});
		
		JPopupMenu popupMenuTrGip = new JPopupMenu();

	
		JMenuItem menuItemHuongDan = new JMenuItem("Hướng dẫn sử dụng");
		menuItemHuongDan.setIcon(new ImageIcon(GUI_HoaDon.class.getResource("/imgs/manual_img.png")));
		menuItemHuongDan.setForeground(new Color(255, 255, 255));
		menuItemHuongDan.setBackground(new Color(136, 74, 57));
		menuItemHuongDan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemHuongDan.setPreferredSize(new Dimension(163, 58));
		popupMenuTrGip.add(menuItemHuongDan);

		
		JMenuItem menuItemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		menuItemDoiMatKhau.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/reload_img.png")));
		menuItemDoiMatKhau.setForeground(new Color(255, 255, 255));
		menuItemDoiMatKhau.setBackground(new Color(136, 74, 57));
		menuItemDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemDoiMatKhau.setPreferredSize(new Dimension(163, 58));
		menuItemDoiMatKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_DMK guiDMK = new GUI_DMK();
				guiDMK.setVisible(true);
				dispose();
				
			}
		});
		popupMenuTrGip.add(menuItemDoiMatKhau);

		
		btnTroGiup.setComponentPopupMenu(popupMenuTrGip);

	
		btnTroGiup.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		        popupMenuTrGip.show(btnTroGiup, 0, btnTroGiup.getHeight());
		    }
		});

		menuItemHuongDan.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemDoiMatKhau.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		
		    }
		});
		
		JButton btnThoat = new JButton("Thoát (Alt + 4)");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setIcon(new ImageIcon(GUI_QuenMK.class.getResource("/imgs/exit_img.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBackground(new Color(17, 57, 70));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.setBounds(978, 59, 165, 58);
		btnThoat.setContentAreaFilled(false);
		btnThoat.setFocusPainted(false);
		btnThoat.setOpaque(true);
		contentPane.add(btnThoat);
		
		btnThoat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnThoat.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnThoat.setBackground(new Color(17, 57, 70));
		    }
		});
		
		btnThoat.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Đóng giao diện hiện tại (GUI_NhanVien)
		        dispose();

		        // Hiển thị lại giao diện GUI_TrangChu
		        GUI_TrangChu guiTrangChu = new GUI_TrangChu();
		        guiTrangChu.setVisible(true);
		    }
		});
		JPanel pnUser = new JPanel();
		pnUser.setBackground(new Color(17, 57, 70));
		pnUser.setBounds(978, 0, 158, 27);
		contentPane.add(pnUser);
		pnUser.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setIcon(new ImageIcon(GUI_KhacHang.class.getResource("/imgs/user_img.png")));
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(10, 0, 108, 20);
		pnUser.add(lblUser);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(107, 11, 0, 0);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_1.setBackground(new Color(17, 57, 70));
		pnUser.add(lblNewLabel_1_1);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/imgs/logout_img.png")));
		btnDangXuat.setForeground(new Color(255, 255, 255));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangXuat.setBackground(new Color(17, 57, 70));
		btnDangXuat.setBounds(978, 27, 158, 33);
		btnDangXuat.setContentAreaFilled(false);
		btnDangXuat.setFocusPainted(false);
		btnDangXuat.setOpaque(true);
		contentPane.add(btnDangXuat);
		
		btnDangXuat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnDangXuat.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDangXuat.setBackground(new Color(17, 57, 70));
		    }
		});

		btnDangXuat.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            GUI_QuenMK lg = new GUI_QuenMK();
		            lg.setVisible(true);
		            lg.setLocationRelativeTo(null);
		            dispose();
		        }
		    }
		});
		
		
		Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                lblNewLabel_1.setText("" + sdf.format(new Date()));
            }
        });
        timer.start();
		
		JLabel lblNewLabel_2 = new JLabel("THÔNG TIN HÓA ĐƠN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(234, 198, 150));
		lblNewLabel_2.setBounds(372, 188, 711, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbMhd = new JLabel("Mã HD:");
		lbMhd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbMhd.setForeground(new Color(234, 198, 150));
		lbMhd.setBounds(27, 119, 88, 37);
		contentPane.add(lbMhd);
		
		JLabel lbMkh = new JLabel("Mã KH:");
		lbMkh.setForeground(new Color(234, 198, 150));
		lbMkh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbMkh.setBounds(241, 119, 88, 37);
		contentPane.add(lbMkh);
		
		JLabel lbMnv = new JLabel("Mã NV:");
		lbMnv.setForeground(new Color(234, 198, 150));
		lbMnv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbMnv.setBounds(456, 119, 88, 37);
		contentPane.add(lbMnv);
		
		JLabel lbMq = new JLabel("Mã quầy:");
		lbMq.setForeground(new Color(234, 198, 150));
		lbMq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbMq.setBounds(680, 119, 88, 37);
		contentPane.add(lbMq);
		
		JLabel lbNl = new JLabel("Ngày lập:");
		lbNl.setForeground(new Color(234, 198, 150));
		lbNl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbNl.setBounds(911, 119, 88, 37);
		contentPane.add(lbNl);
		
		JLabel lbMs = new JLabel("Mã sách:");
		lbMs.setForeground(new Color(234, 198, 150));
		lbMs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbMs.setBounds(10, 314, 88, 28);
		contentPane.add(lbMs);
		
		JLabel lbTs = new JLabel("Tên sách:");
		lbTs.setForeground(new Color(234, 198, 150));
		lbTs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTs.setBounds(10, 348, 88, 28);
		contentPane.add(lbTs);
		
		JLabel lbSl = new JLabel("Số lượng:");
		lbSl.setForeground(new Color(234, 198, 150));
		lbSl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbSl.setBounds(10, 382, 88, 28);
		contentPane.add(lbSl);
		
		JLabel lbDg = new JLabel("Đơn giá:");
		lbDg.setForeground(new Color(234, 198, 150));
		lbDg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbDg.setBounds(10, 416, 88, 28);
		contentPane.add(lbDg);
		
		JLabel lbVAT = new JLabel("VAT:");
		lbVAT.setForeground(new Color(234, 198, 150));
		lbVAT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbVAT.setBounds(10, 449, 88, 28);
		contentPane.add(lbVAT);
		
		JLabel lbUd = new JLabel("Ưu đãi:");
		lbUd.setForeground(new Color(234, 198, 150));
		lbUd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbUd.setBounds(10, 482, 88, 28);
		contentPane.add(lbUd);
		
		JLabel lbTht = new JLabel("Thành tiền:");
		lbTht.setForeground(new Color(234, 198, 150));
		lbTht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTht.setBounds(10, 516, 105, 28);
		contentPane.add(lbTht);
		
		JLabel lbTt = new JLabel("Tổng tiền:");
		lbTt.setForeground(new Color(234, 198, 150));
		lbTt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTt.setBounds(372, 482, 105, 28);
		contentPane.add(lbTt);
		
		JLabel lbTn = new JLabel("Tiền nhận:");
		lbTn.setForeground(new Color(234, 198, 150));
		lbTn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTn.setBounds(623, 482, 105, 28);
		contentPane.add(lbTn);
		
		JLabel lbTthua = new JLabel("Tiền thừa:");
		lbTthua.setForeground(new Color(234, 198, 150));
		lbTthua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbTthua.setBounds(874, 482, 105, 28);
		contentPane.add(lbTthua);
		
		JLabel hinhAnh = new JLabel("");
		hinhAnh.setIcon(new ImageIcon(GUI_HoaDon.class.getResource("/imgs/ttdgbn.jpg")));
		hinhAnh.setForeground(new Color(234, 198, 150));
		hinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hinhAnh.setBounds(94, 157, 129, 140);
		contentPane.add(hinhAnh);
		
		tfMhd = new JTextField();
		tfMhd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfMhd.setColumns(10);
		tfMhd.setBounds(97, 119, 123, 28);
		contentPane.add(tfMhd);
		
		tfMkh = new JTextField();
		tfMkh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfMkh.setColumns(10);
		tfMkh.setBounds(311, 118, 123, 28);
		contentPane.add(tfMkh);

		tfMnv = new JTextField();
		tfMnv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfMnv.setColumns(10);
		tfMnv.setBounds(528, 118, 123, 28);
		contentPane.add(tfMnv);
		
		tfMq = new JTextField();
		tfMq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfMq.setBounds(758, 118, 123, 28);
		contentPane.add(tfMq);
		tfMq.setColumns(10);
		
		tfNl = new JTextField();
		tfNl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfNl.setColumns(10);
		tfNl.setBounds(988, 118, 123, 28);
		contentPane.add(tfNl);
		
		
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		jtMs = new JTextField();
		jtMs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtMs.setColumns(10);
		jtMs.setBounds(104, 314, 123, 28);
		contentPane.add(jtMs);
		
		jtTens = new JTextField();
		jtTens.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtTens.setColumns(10);
		jtTens.setBounds(104, 348, 123, 28);
		contentPane.add(jtTens);
		
		jtSl = new JTextField();
		jtSl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtSl.setColumns(10);
		jtSl.setBounds(104, 382, 123, 28);
		contentPane.add(jtSl);
		
		jtDg = new JTextField();
		jtDg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtDg.setColumns(10);
		jtDg.setBounds(104, 416, 123, 28);
		contentPane.add(jtDg);
		
		jtVAT = new JTextField();
		jtVAT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtVAT.setColumns(10);
		jtVAT.setBounds(104, 449, 123, 28);
		contentPane.add(jtVAT);
		
		jtUd = new JTextField();
		jtUd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtUd.setColumns(10);
		jtUd.setBounds(104, 482, 123, 28);
		contentPane.add(jtUd);
		
		jtTht = new JTextField();
		jtTht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtTht.setColumns(10);
		jtTht.setBounds(104, 516, 123, 28);
		contentPane.add(jtTht);
		
		jtTt = new JTextField();
		jtTt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtTt.setColumns(10);
		jtTt.setBounds(456, 482, 123, 28);
		contentPane.add(jtTt);
		
		jtTn = new JTextField();
		jtTn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtTn.setColumns(10);
		jtTn.setBounds(714, 482, 123, 28);
		contentPane.add(jtTn);
		
		jtTthua = new JTextField();
		jtTthua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtTthua.setColumns(10);
		jtTthua.setBounds(960, 482, 123, 28);
		contentPane.add(jtTthua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 240, 711, 202);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma",Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Mã sách", "Tên sách", "Số lượng", "Đơn giá", "VAT", "Ưu đãi", "Thành tiền"
			}
		));
		
		JButton btnThemSp = new JButton("Thêm sản phẩm vào hóa đơn");
		btnThemSp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemSp.setBackground(new Color(17, 57, 70));
		btnThemSp.setForeground(new Color(234, 198, 150));
		btnThemSp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemSp.setBounds(10, 572, 269, 44);
		contentPane.add(btnThemSp);
		
		JButton btnTaoHd = new JButton("Tạo hóa đơn");
		btnTaoHd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTaoHd.setBackground(new Color(17, 57, 70));
		btnTaoHd.setForeground(new Color(234, 198, 150));
		btnTaoHd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTaoHd.setBounds(322, 572, 269, 44);
		contentPane.add(btnTaoHd);
		
		JButton btnTroveTT = new JButton("Trở về trang chủ");
		btnTroveTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTroveTT.setForeground(new Color(234, 198, 150));
		btnTroveTT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTroveTT.setBackground(new Color(17, 57, 70));
		btnTroveTT.setBounds(640, 572, 269, 44);
		contentPane.add(btnTroveTT);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setForeground(new Color(234, 198, 150));
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLmMi.setBackground(new Color(17, 57, 70));
		btnLmMi.setBounds(953, 572, 173, 44);
		contentPane.add(btnLmMi);
		
		JLabel lblNewLabel_4 = new JLabel("l");
		lblNewLabel_4.setIcon(new ImageIcon(GUI_HoaDon.class.getResource("/imgs/gui_ncc.png")));
		lblNewLabel_4.setBounds(0, 0, 1143, 663);
		contentPane.add(lblNewLabel_4);
		
	
	}
}
