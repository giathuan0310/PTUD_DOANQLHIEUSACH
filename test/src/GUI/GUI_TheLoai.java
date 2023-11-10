package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.NXB_DAO;
import DAO.TheLoai_DAO;
import entity.NhaXuatBan;
import entity.TheLoai;

public class GUI_TheLoai extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbltenTL,lblmaTL;
	private JTextField txtTenTL,txtmaTL;
	
	DefaultTableModel DataModel;
	JTable table;
	private DefaultComboBoxModel<String> cboModelTK;
	private JComboBox<String> comboBox;
	private JTextField textField_4;
	private TheLoai_DAO TL;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TheLoai frame = new GUI_TheLoai();
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
	public GUI_TheLoai() {
		ConnectDB.getInstance().connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý nhà cung cấp");
		
		setBounds(100, 100, 1150, 680);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(234, 198, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 165, 58);
		panel.setBackground(new Color(17, 57, 70));
		contentPane.add(panel);
		
		 JLabel lblNewLabel_1 = new JLabel("");
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(255, 255, 255));
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 lblNewLabel_1.setBackground(new Color(17, 57, 70));
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhà xuất bản");
		lblNewLabel.setBounds(387, -12, 387, 68);
		lblNewLabel.setForeground(new Color(234, 198, 150));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		contentPane.add(lblNewLabel);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setBounds(0, 59, 165, 58);
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
	        menuItemThem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUI_KhacHang guiKH = new GUI_KhacHang();
					guiKH.setVisible(true);
		            dispose();

				}
			});
	        popupMenu.add(menuItemThem);
	        
	        JMenuItem menuItemCapNhat = new JMenuItem("Cập nhật khách hàng");
	        menuItemCapNhat.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
	        menuItemCapNhat.setForeground(new Color(255, 255, 255));
	        menuItemCapNhat.setBackground(new Color(136, 74, 57));
	        menuItemCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        menuItemCapNhat.setPreferredSize(new Dimension(163, 58));
	        menuItemCapNhat.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUI_KhacHang guiKH = new GUI_KhacHang();
					guiKH.setVisible(true);
		            dispose();

				}
			});
	        popupMenu.add(menuItemCapNhat);
	        
	        JMenuItem menuItemTimKiem = new JMenuItem("Tìm khách hàng");
	        menuItemTimKiem.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
	        menuItemTimKiem.setForeground(new Color(255, 255, 255));
	        menuItemTimKiem.setBackground(new Color(136, 74, 57));
	        menuItemTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        menuItemTimKiem.setPreferredSize(new Dimension(163, 58));
	        menuItemTimKiem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUI_KhacHang guiKH = new GUI_KhacHang();
					guiKH.setVisible(true);
		            dispose();

				}
			});
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
		btnSach.setBounds(164, 59, 159, 58);
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
		btnHoaDon.setBounds(322, 59, 165, 58);
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/bill_imng.png")));
		btnHoaDon.setForeground(new Color(255, 255, 255));
		btnHoaDon.setBackground(new Color(17, 57, 70));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHoaDon.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setBounds(486, 59, 165, 58);
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/nhanvien_img.png")));
		btnNhanVien.setForeground(new Color(255, 255, 255));
		btnNhanVien.setBackground(new Color(17, 57, 70));
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		btnNhanVien.setContentAreaFilled(false);
		btnNhanVien.setFocusPainted(false);
		btnNhanVien.setOpaque(true);
		contentPane.add(btnNhanVien);
		
		btnNhanVien.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnNhanVien.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnNhanVien.setBackground(new Color(17, 57, 70));
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
		btnNhanVien.setComponentPopupMenu(popupMenuNhanVien);

		
		btnNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        popupMenuNhanVien.show(btnNhanVien, 0, btnNhanVien.getHeight());
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
		btnNhaCungCap.setBounds(650, 59, 165, 58);
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/ncc_img.png")));
		btnNhaCungCap.setForeground(new Color(255, 255, 255));
		btnNhaCungCap.setBackground(new Color(17, 57, 70));
		btnNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		popupMenuNCC.add(menuItemThemNCC);

		
		JMenuItem menuItemCapNhatNCC = new JMenuItem("Cập nhật NCC");
		menuItemCapNhatNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNCC.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNCC.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemCapNhatNCC.setPreferredSize(new Dimension(163, 58));
		popupMenuNCC.add(menuItemCapNhatNCC);

	
		JMenuItem menuItemTimKiemNCC = new JMenuItem("Tìm NCC");
		menuItemTimKiemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNCC.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNCC.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNCC.setPreferredSize(new Dimension(163, 58));
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
		btnTroGiup.setBounds(814, 59, 165, 58);
		btnTroGiup.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/help_img.png")));
		btnTroGiup.setHorizontalAlignment(SwingConstants.LEFT);
		btnTroGiup.setForeground(new Color(255, 255, 255));
		btnTroGiup.setBackground(new Color(17, 57, 70));
		btnTroGiup.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		menuItemHuongDan.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/manual_img.png")));
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
		btnThoat.setBounds(978, 59, 165, 58);
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/imgs/exit_img.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBackground(new Color(17, 57, 70));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBounds(978, 25, 158, 33);
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/imgs/logout_img.png")));
		btnDangXuat.setForeground(new Color(255, 255, 255));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangXuat.setBackground(new Color(17, 57, 70));
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
		        	GUI_DangNhap lg = new GUI_DangNhap();
		            lg.setVisible(true);
		            dispose();
		        }
		    }
		});
		JPanel pnUser = new JPanel();
		pnUser.setBounds(978, 0, 165, 25);
		pnUser.setBackground(new Color(17, 57, 70));
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
		
		Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                lblNewLabel_1.setText("" + sdf.format(new Date()));
            }
        });
        timer.start();

		
		
		
		
		////
		lbltenTL=new JLabel("Tên thể loại");
		lbltenTL.setBounds(98, 181, 151, 44);
		lbltenTL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenTL.setForeground(new Color(234, 198, 150));
        contentPane.add(lbltenTL);
		
		 lblmaTL = new JLabel("Mã thể loại");
		 lblmaTL.setBounds(623, 181, 165, 44);
		lblmaTL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaTL.setForeground(new Color(234, 198, 150));
		contentPane.add(lblmaTL);
	
	txtTenTL = new JTextField();
	txtTenTL.setBounds(248, 182, 239, 42);
	txtTenTL.setFont(new Font("Tahoma", Font.PLAIN, 18));
	contentPane.add(txtTenTL);
	txtTenTL.setColumns(10);
	
	txtmaTL = new JTextField();
	txtmaTL.setBounds(784, 182, 239, 42);
	txtmaTL.setFont(new Font("Tahoma", Font.PLAIN, 18));
	txtmaTL.setColumns(10);
	contentPane.add(txtmaTL);
		
		
		
	
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(77, 330, 973, 186);
	String[] headers= "Tên thể loại;Mã thể loại".split(";");
	DataModel=new DefaultTableModel(headers,0);
	
	scrollPane.setViewportView(table=new JTable(DataModel));
	table.setRowHeight(25);
	table.setAutoCreateRowSorter(true);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	//table.setPreferredSize(new Dimension(500, 300));
	contentPane.add(scrollPane);
		
		
	JLabel label = new JLabel("New label");
	label.setBounds(169, 72, 36, 32);
	contentPane.add(label);
	
	JButton btnThem = new JButton("Thêm");
	btnThem.setBackground(new Color(17, 57, 70));
	btnThem.setForeground(new Color(234, 198, 150));
	btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnThem.setBounds(25, 526, 140, 44);
	contentPane.add(btnThem);
	
	
	JButton btnCapNhat = new JButton("Cập nhật");
	btnCapNhat.setBackground(new Color(17, 57, 70));
	btnCapNhat.setForeground(new Color(234, 198, 150));
	btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnCapNhat.setBounds(218, 526, 140, 44);
	contentPane.add(btnCapNhat);
	
	cboModelTK = new DefaultComboBoxModel<String>();
	comboBox = new JComboBox<String>(cboModelTK);
	comboBox.setForeground(new Color(249, 224, 187));
	comboBox.setBackground(new Color(17, 57, 70));
	comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
	comboBox.setBounds(702, 528, 135, 42);
	contentPane.add(comboBox);
	updateJComboBox();
	
	textField_4 = new JTextField();
	textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
	textField_4.setBounds(837, 528, 142, 42);
	contentPane.add(textField_4);
	textField_4.setColumns(10);
	JButton btnSearch = new JButton("");
	btnSearch.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/search_img.png")));
	btnSearch.setBackground(new Color(17, 57, 70));
	btnSearch.setBounds(978, 528, 45, 42);
	contentPane.add(btnSearch);
	
	//1.Add data dô bảng
	TL =new TheLoai_DAO();
	table.setRowHeight(25);
	for(TheLoai n:TL.getAllTL()) {
		
		Object[] rowData= {n.getMaTheLoai(),n.getTenTheLoai()};
		DataModel.addRow(rowData);
	}
	
	table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			assert row >= 0;
			napLopHocVaoTextfields();
		}
	});
	
	
	JLabel lblNewLabel_4 = new JLabel("l");
	lblNewLabel_4.setBounds(0, 0, 1143, 643);
	lblNewLabel_4.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/gui_ncc.png")));
	contentPane.add(lblNewLabel_4);
	}
	
	private void napLopHocVaoTextfields() {
		int row = table.getSelectedRow();
		if (row >= 0) {
			txtmaTL.setText((String) table.getValueAt(row, 0));
			txtTenTL.setText((String) table.getValueAt(row, 1));
			
			
			

			
		}
	}
	
	private void updateJComboBox() {
		cboModelTK.addElement("Mã Nhà Cung Cấp");
		cboModelTK.addElement("Tên Nhà Cung Cấp");
		
	}

}
